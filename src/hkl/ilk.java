//################################################################
//	Dieses Programm wurde von Olcay Akgün im Juni 2018 entwickelt.
//  Developed by Olcay Akgün, June 2018
//
//	Github Seite: https://github.com/olcayakgn/Numbers-in-German
//  Github Page: https://github.com/olcayakgn/Numbers-in-German
//
//	Copyright (c) 2018 Olcay Akgün. 
//  Um mehr zu erfahren, bitte Kontakt aufnehmen 
//  For more Information, please contact
//	olcayakgn1@gmail.com
//	
//	Sobald diese Ankündigung dabei behaltet werden, Modifizierung ist erlaubt.
//	As long as this notice intact kept, modification is allowed.
//
//	GNU Affero General Public License v3.0
//  Mehr Information über Copyright
//	More Information about Copyright
//  https://github.com/olcayakgn/Numbers-in-German/blob/master/LICENSE
//################################################################

package hkl;

public class ilk {

	public static void main(String[] args) {
	
		System.out.println(todeutsch(44456325));
		
	}
	
	public static String e_stelle_Rechnen (int y)   // (DE) Erzeugt einen String Wert, der die Aussprache einer Zahl entspricht.
	{												// Damit können die erste Stelle gerechnet werden.
		
		String e_stelle_z_stelle_resultatat = null; // (EN) Produces a string value that matches pronunciation of the Number.
		switch(y) 									// With that first digit can be calculated.
		{
		case 0:e_stelle_z_stelle_resultatat ="";
		break;
		case 1:e_stelle_z_stelle_resultatat="eins";
		break;
		case 2:e_stelle_z_stelle_resultatat="zwei";
		break;
		case 3:e_stelle_z_stelle_resultatat="drei";
		break;
		case 4:e_stelle_z_stelle_resultatat="vier";
		break;
		case 5:e_stelle_z_stelle_resultatat="fünf";
		break;
		case 6:e_stelle_z_stelle_resultatat="sechs";
		break;
		case 7:e_stelle_z_stelle_resultatat="sieben";
		break;
		case 8:e_stelle_z_stelle_resultatat="acht";
		break;
		case 9:e_stelle_z_stelle_resultatat="neun";
		break;
		default:e_stelle_z_stelle_resultatat= "";
		}
		return e_stelle_z_stelle_resultatat;
	}
	
	public static String hochwertige_Stelle(int stelle_a, int stelle_b, boolean rechnen_methode)
	{														//(DE) Erzeugt einen String Wert, der die Aussprache der hochwertigen Stelle entspricht.
		String hw_stelle_resultatat = null;                 // Zwei verschieden Rechnenmethoden waren nötig, weil die größen Zahlen wie z.B. 
		if(rechnen_methode==true) {                         // 120200256 zwei verschiedene hochwertige Stelle besitzen: Millionen und Tausend
			switch(String.valueOf(stelle_a).length())
			{												// (EN) Produces a string value that matches the pronunciation of high value digit.
															// Two types of calculation methods was required, because numbers for example
			case 3: hw_stelle_resultatat = "hundert";break; // 120200256 has two different high value digits : millions and thousands
			case 4: hw_stelle_resultatat  = "tausend";break;
			case 5: hw_stelle_resultatat = "tasuend";break;
			case 6: hw_stelle_resultatat = "tausend";break;
			case 7: hw_stelle_resultatat= "millionen";break;
			case 8: hw_stelle_resultatat = "millionen";break;
			case 11: hw_stelle_resultatat = "millionen";break;
			default: hw_stelle_resultatat = "";
			}
		}
		if(rechnen_methode ==false)
		{
			switch(stelle_b)
			{
			case 3: hw_stelle_resultatat = "hundert";break;
			case 4: hw_stelle_resultatat  = "tausend";break;
			case 5: hw_stelle_resultatat = "tasuend";break;
			case 6: hw_stelle_resultatat = "tausend";break;
			case 7: hw_stelle_resultatat= "millionen";break;
			case 8: hw_stelle_resultatat = "millionen";break;
			case 11: hw_stelle_resultatat = "millionen";break;
			default: hw_stelle_resultatat = "";
			}
		}
		
		
		return hw_stelle_resultatat;
	}
	public static String d_stelle_Rechnen (int g, int b)             // (DE) Erzeugt einen String Wert, der die Aussprache der drei stelligen Zahl entspricht.
																	 // Zwei Eingaben waren nötig, weil die hochwertige Zahlen unterschiedlich zu behandeln sind
	{																 // (EN) Two inputs was requiered, because high value numbers should threaded different
		String stringvalueof_g = String.valueOf(g);                  // Produces a string value that matches the pronunciation of three digit number
		stringvalueof_g = stringvalueof_g.replaceFirst ("^0*", "");  
		g = Integer.parseInt(stringvalueof_g);						 
		
		String d_stelle_wert = null;
		String z_stelle_resultat = null;
		boolean hoch_wertig=false;
		int yy = (int) Math.pow(10, ((int)Math.log10(g)));
		int dritterb = g/yy;
		int niedrig = g - dritterb*100;
		d_stelle_wert = e_stelle_Rechnen(dritterb) ;
		
		if(b>20){
			if(d_stelle_wert.equalsIgnoreCase(e_stelle_Rechnen(1))) {
				d_stelle_wert="ein";
			}
		}
		StringBuffer strb0 = new StringBuffer();
		strb0.append(d_stelle_wert);
		
		if(String.valueOf(b).length()==6){
			int temp = String.valueOf(g).length();
			strb0.append(hochwertige_Stelle(0,temp,false));
			hoch_wertig=true;
		}
		else{
			strb0.append(hochwertige_Stelle(b,0,true));
		}
		
		strb0.append(z_stelle_Rechnen(niedrig,niedrig));
		if(hoch_wertig==true) {
			strb0.append(hochwertige_Stelle(b,0,true));
		}
		z_stelle_resultat = strb0.toString();
		return z_stelle_resultat;
	}
	
	public static String z_stelle_Rechnen (int h, int s)
	{
		String erste_stelle,zweite_Stelle,z_stelle_resultat = null;
		String und = "und";
		int birler = h %10;
		
		erste_stelle = e_stelle_Rechnen(birler);

		int onlar = (int) h/10;
		switch(onlar) {
		case 1: zweite_Stelle="zehn";
				break;
		case 2: zweite_Stelle="zwanzig";
				break;
		case 3: zweite_Stelle="dreißig";
				break;
		case 4: zweite_Stelle="vierzig";
				break;
		case 5: zweite_Stelle="fünfzig";
				break;
		case 6: zweite_Stelle="sechszig";
				break;
		case 7: zweite_Stelle="siebzig";
				break;
		case 8: zweite_Stelle="achtzig";
				break;
		case 9: zweite_Stelle="neunzig";
				break;
		default: zweite_Stelle = "";
			}
		StringBuffer strp = new StringBuffer();
		strp.append(erste_stelle);
		if(erste_stelle.equalsIgnoreCase("") || zweite_Stelle.equalsIgnoreCase("") || h<20)
		{
			und ="";
		}
		strp.append(und);
		strp.append(zweite_Stelle);
		if(s >= 1000)
		{
			
			strp.append(hochwertige_Stelle(s,0,true));
		}
		
		z_stelle_resultat = strp.toString();
		if(z_stelle_resultat.equalsIgnoreCase("einszehn"))
			z_stelle_resultat = "elf";
		if(z_stelle_resultat.equalsIgnoreCase("zweizehn"))
			z_stelle_resultat="zwölf";
		
		return z_stelle_resultat;
		
		
	}
	public static String todeutsch (int x)
	{
		String NumberinGerman = null;
		int stelle_wert = String.valueOf(x).length();
			if(String.valueOf(x).length()<=2)
				NumberinGerman = z_stelle_Rechnen(x,x);
		if(String.valueOf(x).length() ==3)
			NumberinGerman= d_stelle_Rechnen(x,x);
		
		if(stelle_wert>=4)
		{
			String resultat_teil0=null, resultat_teil1 = null, resultat_teil2 = null;
			switch(String.valueOf(x).length())
			{
			case 4: resultat_teil1 = d_stelle_Rechnen((int)x/1000, x);
					x = x - 1000*((int)x/1000);
					resultat_teil2= d_stelle_Rechnen(x,x);
					NumberinGerman = resultat_teil1 + resultat_teil2;
					break;
			case 5: resultat_teil1 = z_stelle_Rechnen(((int)x/1000), x);
					x = x - 1000*((int)x/1000);
					if(x>=100)
						resultat_teil2 = d_stelle_Rechnen(x,x);
					if(x<100)
						resultat_teil2 = z_stelle_Rechnen(x,x);
					NumberinGerman = resultat_teil1+ resultat_teil2;
					break;
			case 6: resultat_teil1 = d_stelle_Rechnen(((int)x/1000), x);
					x = x - 1000*((int)x/1000);
					if(x>=100)
						resultat_teil2= d_stelle_Rechnen(x,x);
					if(x<100)
						resultat_teil2=z_stelle_Rechnen(x,x);
					
					NumberinGerman = resultat_teil1 + resultat_teil2;
					break;
			case 7: resultat_teil0 = z_stelle_Rechnen(((int)x/1000000),x);
					x= x - ((int)x/1000000)*1000000;
					
					if(x>=100000)
						resultat_teil1 = d_stelle_Rechnen(((int)x/1000), x);
					if(x<100000)
						resultat_teil1 = z_stelle_Rechnen(((int)x/1000), x);
					x = x - 1000*((int)x/1000);

					if(x>=100)
						resultat_teil2= d_stelle_Rechnen(x,x);
					if(x<100)
						resultat_teil2=z_stelle_Rechnen(x,x);
					NumberinGerman = resultat_teil0+ resultat_teil1+ resultat_teil2;
					break;
			case 8: resultat_teil0 = z_stelle_Rechnen(((int)x/1000000),x);
					x= x - ((int)x/1000000)*1000000;
					
					if(x>=100000)
						resultat_teil1 = d_stelle_Rechnen(((int)x/1000), x);
					if(x<100000)
						resultat_teil1 = z_stelle_Rechnen(((int)x/1000), x);
					
					x = x - 1000*((int)x/1000);
					
					if(x>=100)
						resultat_teil2= d_stelle_Rechnen(x,x);
					if(x<100)
						resultat_teil2=z_stelle_Rechnen(x,x);
					NumberinGerman = resultat_teil0+ resultat_teil1+ resultat_teil2;
					break;
			}
		}
		return NumberinGerman;
		
	}
}



