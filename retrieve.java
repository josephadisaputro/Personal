package testing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class retrieve {
	public static ArrayList<String> retrieveAccountLog(){
		String FILENAME = "/cs/home/yusufadi/Desktop/test.txt";
		BufferedReader br = null;
		FileReader fr = null;
		TreeMap<Integer, String> dataLog = new TreeMap<Integer, String>();
		ArrayList<String> accountLog = new ArrayList<String>();
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine = null;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] line = sCurrentLine.split(" ");
				dataLog.put(Integer.parseInt(line[0]), sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		Set set = dataLog.entrySet();
		Iterator i = set.iterator();
	    while(i.hasNext()) {
	    	Map.Entry me = (Map.Entry)i.next();
	    	accountLog.add((String) me.getValue());
	    }
	    distinguishing(accountLog);
		return accountLog;
	}
	
	public static void distinguishing(ArrayList<String> accountLog){
		int sin = 0;
		double limit = 0;
		String accountType = "";
		String type = "";
		for(int i = 0; i < accountLog.size(); i++){
			String[] words = (accountLog.get(i)).split(" ");
			sin = Integer.parseInt(words[0]);
			for(int j = 0; j < words.length; j++){
				if(words[j].equals("accounttype:")){
					accountType = words[j+1];
				}else if(words[j].equals("type:")){
					type = words[j+1];
				}else if(words[j].equals("limt:")){
					limit = Double.parseDouble(words[j+1]);
				}else if(words[j].equals("|")){
					//createAccount(sin, accountType, type, limit);
					
					System.out.println(sin + " " + accountType + " " + type + " " +  limit);
				}
			}
		}
	}
	
	public static void saveAccountLog(ArrayList<String> accountLog) throws IOException{
		String FILENAME = "/cs/home/yusufadi/Desktop/test2.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true));
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine = null;
			int i = 0;
			String[] useless = (br.readLine()).split(" ");
			String tmp = useless[0];
			while ((sCurrentLine = br.readLine()) != null) {
				String[] line1 = sCurrentLine.split(" ");
				String[] lineINaccountLog = (accountLog.get(i)).split(" ");
				if(!tmp.equals(line1[0])){
					writer.append('\n');
					writer.append(accountLog.get(i));
					i = i + 1;
				}
			}
		    String str = "testing testing testing";
		    writer.append('\n');
		    writer.append(str);
		     
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException{
		ArrayList<String> accountLog = new ArrayList<String>();
		accountLog = retrieveAccountLog();
		for(int i = 0; i < accountLog.size(); i++){
		//	System.out.println(accountLog.get(i));
		}
		saveAccountLog(accountLog);
	}
}
