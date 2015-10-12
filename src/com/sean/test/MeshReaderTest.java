package com.sean.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sean.wang.utils.FileIO;
import com.sean.wang.utils.MeshReader;

import junit.framework.TestCase;

public class MeshReaderTest extends TestCase{
	
	public void testReader() throws IOException {
		List<double[]> vertices = new ArrayList<>();
		List<int[]> elements = new ArrayList<>();
		MeshReader.fromICEM3D
				    .path("E:/data/prj.exp")
				    .readVertices(vertices)
				    .readElements(elements);
		System.out.println(vertices.size());
		System.out.println(elements.size());
		
		FileIO.writeDoubleArrList(vertices, "E:/data/vertices.txt", "\t");
		FileIO.writeIntArrList(elements, "E:/data/elements.txt", "\t");
		
	}
	
	public void testStandardFormat(){
		List<double[]> vertices = new ArrayList<>();
		List<int[]> edges = new ArrayList<>();
		List<int[]> faces = new ArrayList<>();
		List<int[]> elements=  new ArrayList<>();
		List<int[]> surface = new ArrayList<>();
		MeshReader.fromStandardFormat
				  .setPath("E:/data")
				  .readVertices(vertices)
				  .readEdges(edges)
				  .readFace(faces)
				  .readElements(elements)
				  .readSurface(surface);
		System.out.println(vertices.size());
		System.out.println(edges.size());
		System.out.println(faces.size());
		System.out.println(elements.size());
		System.out.println(surface.size());
	}
}
