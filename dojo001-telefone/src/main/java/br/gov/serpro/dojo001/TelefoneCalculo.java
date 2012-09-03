package br.gov.serpro.dojo001;

import java.util.HashMap;
import java.util.Map;

public class TelefoneCalculo {
	
	private Map<String, Integer> mapa = new HashMap<String, Integer>();
	
	public TelefoneCalculo() {
		mapa.put("abcABC", 2);
		mapa.put("defDEF", 3);
		mapa.put("ghiGHI", 4);
		mapa.put("jklJKL", 5);
		mapa.put("mnoMNO", 6);
		mapa.put("pqrsPQRS", 7);
		mapa.put("tuvTUV", 8);
		mapa.put("wxyzWXYZ", 9);
	}
	
	public Integer getNumberByChar(Character c) {
		Integer result = null;
		if(c != null) {
			String cStr = c.toString();
			for (String str : mapa.keySet()) {
				if (str.contains(cStr)) {
					return mapa.get(str);
				}
			}
		}
		return result;
	}

	public String getNumberByString(String string) {
		
		StringBuilder retorno = new StringBuilder();
		
		for (Character c : string.toCharArray()){			
			Integer numberByChar = this.getNumberByChar(c);
			if(numberByChar == null)
				return null;
			retorno.append(numberByChar); 
		}
		return retorno.toString();
	}

}
