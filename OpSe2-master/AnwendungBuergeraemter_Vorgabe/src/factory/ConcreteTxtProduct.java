package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteTxtProduct extends Product{
	private BufferedWriter buffi = null;
	
	public ConcreteTxtProduct() {
		try {
			buffi = new BufferedWriter(new FileWriter("Buergeraemter.txt",true));
			} catch(IOException e) {
			}
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		Buergeramt buergi = (Buergeramt) object;
		String buergerAmtAlsString = getBuergeramtAlsString(buergi, ';');
		
		buffi.write(buergerAmtAlsString);
		buffi.flush();
	}

	@Override
	public void schliesseDatei() throws IOException {
		buffi.close();
		
	}
	
	private String getBuergeramtAlsString(Buergeramt buergeramt, char trenner) {
		return "Daten des B�rgeramts" + "\n"
				+ "Name des B�rgeramts: " + buergeramt.getName() + "\n"
				+ "�ffnungszeit des B�rgeramts: " + buergeramt.getGeoeffnetVon() + " - " + buergeramt.getGeoeffnetBis() + "\n"
				+ "Stra�e und Hausnummer des B�rgeramts: " + buergeramt.getStrasseHNr() + "\n"
				+ "Dienstleistungen des B�rgeramts: " + buergeramt.getDienstleistungenAlsString(trenner) + "\n";	
	}
}
