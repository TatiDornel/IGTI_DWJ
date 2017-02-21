package br.igti.webjava.util;

import java.time.LocalDateTime;

public class Util {

	 public static boolean isNull(String s){
		 return s == null;
	 }
	 public static boolean isNull(Object s){
		 return s == null;
	 }
	 public static boolean isNull(Integer s){
		 return s == null;
	 }
	 
	 public static LocalDateTime agora(){
		 return LocalDateTime.now();
	 }
}
