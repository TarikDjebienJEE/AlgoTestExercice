package exercice2;

public class LunKey {
	
	public int charToInt(char c){
		return Integer.valueOf(String.valueOf(c)).intValue();
	}
	
	public int addTwoNumericChar(int value){
		String valueCopy = String.valueOf(value);
		return charToInt(valueCopy.charAt(0)) + charToInt(valueCopy.charAt(1));
	}
	
	public int generateKey(String seq){
		StringBuilder seqCopy = new StringBuilder(seq.replaceAll(" ", ""));
		int result = 0;
		for(int i=seqCopy.length()-1;i>=0;i--){
			int value = charToInt(seqCopy.charAt(i));
			if (seqCopy.length() % 2 == 0 && i % 2 == 1) {
				value = value * 2;
				if(value >= 10){
					value = addTwoNumericChar(value); 
				}
			} else if (i % 2 == 1 && seqCopy.length() % 2 == 0) {
				value = value * 2;
				if(value >= 10){
					value = addTwoNumericChar(value); 
				}
			}
			result += value;
		}
		return (10 - (result % 10)) % 10;
	}

	public static void main(String[] args) {
//		System.out.println(new LunKey().generateKey("6703 123 4567890 01"));
//		System.out.println(new LunKey().generateKey("6703 123 4567890 02"));
		System.out.println(new LunKey().generateKey("876"));
	}
}
