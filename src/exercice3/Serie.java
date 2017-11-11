package exercice3;

public class Serie {
	
	public void algo(int n) {
		String result = "1";
		for (int i=1;i<=n;i++) {
			System.out.println("sequence "+i+" : "+result);
			result = read(result);
		}
	}
	
	public String read(String seq){
			int cpt = 0;
			char tmp = ' ';
			StringBuilder result = new StringBuilder();
			for(int i=0;i<seq.length();i++){
				if(tmp != seq.charAt(i) && cpt != 0) {
					result.append(Integer.valueOf(cpt)).append(String.valueOf(tmp));
					cpt = 1;
				} else {
					cpt++;
				}
				tmp = seq.charAt(i);
			}
			result.append(Integer.valueOf(cpt)).append(String.valueOf(tmp));
			return result.toString();
		}
	
	public static void main(String[] args) {
		new Serie().algo(7);
	}
}
