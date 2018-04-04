import opennlp.tools.namefind.*;
import opennlp.tools.tokenize.*;
import opennlp.tools.util.*;
import java.util.*;
import java.io.*;

class sarvagnaNER
{
	public static void main(String[] args) 
	{
		
			try
		{
			InputStream TokenFile = new FileInputStream(new File("en-token.bin"));
			InputStream ModelFile = new FileInputStream(new File("en-ner-person.bin"));
			TokenizerModel tokenModel = new TokenizerModel(TokenFile);
			Tokenizer tokenizer = new TokenizerME(tokenModel);
			TokenNameFinderModel entityModel = new TokenNameFinderModel(ModelFile);
			NameFinderME namefinder = new NameFinderME(entityModel);

	
			System.out.println("Enter a string");
			Scanner sc = new Scanner(System.in);
			String sentence;
			sentence = sc.nextLine();
			String tokens[] = tokenizer.tokenize(sentence);
			Span nameSpans[] = namefinder.find(tokens);
			for(int i=0;i<nameSpans.length;i++)
			{
				System.out.println("Span: "+nameSpans[i].toString());
				System.out.println("Entity: "+tokens[nameSpans[i].getStart()]);
			}
		}
		
		catch(FileNotFoundException e)
		{

		}
		catch(IOException q)
		{

		}			
			
	}
}