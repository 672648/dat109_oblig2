package utilitet.dat109;

public class Adresse {
	private String gateAdresse;
	private String postSted;
	private int postNummer;
	
	public Adresse(String gateAdresse, String postSted, int postNummer) {
		this.gateAdresse = gateAdresse;
		this.postSted = postSted;
		this.postNummer = postNummer;
	}
	
	public String getGateAdresse() {
		return this.gateAdresse;
	}
	
	public void setGateAdresse(String gateAdresse) {
		this.gateAdresse = gateAdresse;
	}
	
	public String getPostSted() {
		return this.postSted;
	}
	
	public void setPostSted(String postSted) {
		this.postSted = postSted;
	}
	
	public int getPostNummer() {
		return this.postNummer;
	}
	
	public void setPostNummer(int postNummer) {
		this.postNummer = postNummer;
	}
}
