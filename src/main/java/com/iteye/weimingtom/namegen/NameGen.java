package com.iteye.weimingtom.namegen;

import jakarta.servlet.ServletContext;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class NameGen {
	private MersenneTwisterRandom mt;
	private List<String> familyNames;
	private List<String> singleNames;
	private List<String> doubleFirstNames;
	private List<String> doubleSecondNames;
	private List<String> feminineNames;

	public NameGen(ServletContext context) {
		familyNames = readLines(context, "/WEB-INF/data/surname.txt");
		singleNames = readLines(context, "/WEB-INF/data/ChsSingleName.txt");
		doubleFirstNames = readLines(context, "/WEB-INF/data/ChsDoubleName1.txt");
		doubleSecondNames = readLines(context, "/WEB-INF/data/ChsDoubleName2.txt");
		feminineNames = readLines(context, "/WEB-INF/data/feminine.txt");

		mt = new MersenneTwisterRandom();
		mt.init_genrand((int) System.currentTimeMillis());
	}
//	public NameGen() {
//		familyNames = readLines("data/surname.txt");
//		singleNames = readLines("data/ChsSingleName.txt");
//		doubleFirstNames = readLines("data/ChsDoubleName1.txt");
//		doubleSecondNames = readLines("data/ChsDoubleName2.txt");
//		feminineNames = readLines("data/feminine.txt");
//
//		mt = new MersenneTwisterRandom();
//		mt.init_genrand((int)System.currentTimeMillis());
//	}

	public String getName() {
		int nameLength = (mt.nextInt(0, 9) > 7 ? 2 : 3);
		String name = "";
		if (nameLength < 3) {
			if (familyNames.size() == 0 || 
				singleNames.size() == 0) {
				return name;
			}
			String familyName = familyNames.get(mt.nextInt(0, familyNames.size() - 1));
			String singleName = singleNames.get(mt.nextInt(0, singleNames.size() - 1));
			name = familyName + singleName;
		} else {
			if (familyNames.size() == 0 || 
				doubleFirstNames.size() == 0 || 
				doubleSecondNames.size() == 0) {
				return name;
			}
			String familyName = familyNames.get(mt.nextInt(0, familyNames.size() - 1));
			String doubleFirstName = doubleFirstNames.get(mt.nextInt(0, doubleFirstNames.size() - 1));
			String doubleSecondName = doubleSecondNames.get(mt.nextInt(0, doubleSecondNames.size() - 1));
			name = familyName + doubleFirstName + doubleSecondName;
		}
		return name;
	}
	
	public String getSex(String name) {
		if (name == null || name.length() <= 1) {
			return "男";
		}
		String sex = "男";
		for (int i = 0; i < name.length(); i++) {
			String nameChar = name.substring(i, i+1);
			if (feminineNames.contains(nameChar)) {
				sex = "女";
				break;
			}
		}
		return sex;
	}

	private List<String> readLines(ServletContext context, String filename) {
		List<String> results = new ArrayList<>();
		InputStream istr = null;
		Reader reader = null;
		BufferedReader ibuf = null;
		try {
			// 使用ServletContext获取文件的绝对路径
			String fullPath = context.getRealPath(filename);
			istr = new FileInputStream(fullPath);
			reader = new InputStreamReader(istr, "UTF-8");
			ibuf = new BufferedReader(reader);
			String line;
			while ((line = ibuf.readLine()) != null) {
				// 省略的部分保持不变
				results.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 省略的部分保持不变
		}
		return results;
	}

//	private List<String> readLines(String filename) {
//		List<String> results = new ArrayList<String>();
//		InputStream istr = null;
//		Reader reader = null;
//		BufferedReader ibuf = null;
//		try {
//			istr = new FileInputStream(filename);
//			reader = new InputStreamReader(istr, "UTF-8");
//			ibuf = new BufferedReader(reader);
//			String line;
//			while((line = ibuf.readLine()) != null) {
//				if (line.length() > 1) {
//					byte[] bom = line.substring(0, 1).getBytes("UTF-8");
//					/*
//					if (bom.length == 3) {
//						for (byte bombyte : bom) {
//							System.out.println(Integer.toHexString(bombyte & 0xff));
//						}
//					}
//					*/
//					if (bom.length == 3 &&
//						((bom[0] & 0xff) == 0xef) &&
//						((bom[1] & 0xff) == 0xbb) &&
//						((bom[2] & 0xff) == 0xbf)) {
//						line = line.substring(1);
//					}
//					//System.out.println("line : " + line + "," + filename + "," + line.length());
//				}
//				results.add(line);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if (ibuf != null) {
//				try {
//					ibuf.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (reader != null) {
//				try {
//					reader.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (istr != null) {
//				try {
//					istr.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		return results;
//	}

	
	
	
//	public static void main(String[] args) {
//		NameGen nameGen = new NameGen();
//
//		for (int i = 0; i < 100; i++) {
//			String name = nameGen.getName();
//			String sex = nameGen.getSex(name);
//			System.out.println("" + i + " : " + name + " - " + sex);
//		}
//	}
	
}
