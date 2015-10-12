package com.sean.wang.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.sean.exceptions.PathNotValidException;

public class MeshReader {
	
	public static FromICEM3D fromICEM3D = new FromICEM3D();
	public static FromStandardFormat fromStandardFormat = new FromStandardFormat();
	
	public static class FromICEM3D{
		
		private String path = null;
		private final static String NODE_START = "*NODE";
		private final static String ELEMENT_START = "*ELEMENT_SOLID";
		private final static String END = "$";
		
		public FromICEM3D path(String path){
			this.path = path;
			return this;
		}
		
		public FromICEM3D readVertices(List<double[]> vertices){
			checkPath();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				String s = null;
				s = reader.readLine();
				while(!s.equals(NODE_START)) {
					s = reader.readLine();
				}
				s = reader.readLine();
				s = reader.readLine().trim();
				while(!s.equals(END)){
					String[] strs = s.split("\\s+");
					vertices.add(new double[]{Double.parseDouble(strs[1]), Double.parseDouble(strs[2]),
							Double.parseDouble(strs[3])});
					s = reader.readLine().trim();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return this;
		}
		public FromICEM3D readElements(List<int[]> elements){
			checkPath();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				String s = null;
				s = reader.readLine();
				while(!s.equals(ELEMENT_START)) {
					s = reader.readLine();
				}
				s = reader.readLine().trim();
				while(!s.equals(END)) {
					String[] strs = s.split("\\s+");
					if(strs.length != 8) {
						s = reader.readLine().trim();
						continue;
					}
					List<Integer> elem = new ArrayList<>();
					elem.add(Integer.parseInt(strs[0]) - 1);
					for(int i = 1; i < 8; i++) {
						int v = Integer.parseInt(strs[i]) - 1;
						if(elem.get(i - 1) == v) {
							break;
						}
						elem.add(v);
					}
					elements.add(LsUtil.toIntArray(elem));
					s = reader.readLine().trim();
				
				}
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			return this;
		}
		
		private void checkPath(){
			if(path == null) {
				throw new PathNotValidException("need specify a valid path");
			}
		}
	}
	
	public static class FromStandardFormat{
		
		private String path;
		
		public FromStandardFormat setPath(String path){
			this.path = path;
			return this;
		}
		
		public FromStandardFormat readVertices(List<double[]> vertices){
			return readDouble(vertices, "vertices.txt");
		}
		public FromStandardFormat readEdges(List<int[]> edges){
		    return	readInt(edges, "edges.txt");
		}
		public FromStandardFormat readFace(List<int[]> faces){
			return readInt(faces, "faces.txt");
		}
		public FromStandardFormat readElements(List<int[]> elements){
			return readInt(elements, "elements.txt");
		}
		public FromStandardFormat readSurface(List<int[]> surface){
			return readInt(surface, "surface.txt");
		}
		private FromStandardFormat readDouble(List<double[]> list, String fileName){
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path + File.separator + fileName));
				String line = null;
				while((line = reader.readLine()) != null) {
					String[] strs = line.split("\\s+");
					list.add(new double[]{Double.parseDouble(strs[0]), Double.parseDouble(strs[1])});
				}
				reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			return this;
		}
		private FromStandardFormat readInt(List<int[]> list, String fileName){
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path + File.separator + fileName));
				String line = null;
				while((line = reader.readLine()) != null) {
					String[] strs = line.split("\\s+");
					int[] result = new int[strs.length];
					for(int i = 0, len = strs.length; i < len; i++){
						result[i] = Integer.parseInt(strs[i]);
					} 
					list.add(result);
				}
				reader.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			return this;
		}
	}
}
