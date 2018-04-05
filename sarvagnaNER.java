import opennlp.tools.namefind.*;
import opennlp.tools.tokenize.*;
import opennlp.tools.util.*;
import java.util.*;
import java.io.*;

class sarvagnaNER
{
	public static void main(String[] args) 
	{
			System.out.println("Enter a string");
			Scanner sc = new Scanner(System.in);
			String sentence;
			sentence = sc.nextLine();
			try
			{
				String modelNames[]={"en-ner-person.bin","en-ner-location.bin", "en-ner-organization.bin","en-ner-money.bin"};
				ArrayList<String> list = new ArrayList();

				for(String name:modelNames)
				{
					InputStream TokenFile = new FileInputStream(new File("en-token.bin"));
					InputStream ModelFile = new FileInputStream(new File(name));
					TokenizerModel tokenModel = new TokenizerModel(TokenFile);
					Tokenizer tokenizer = new TokenizerME(tokenModel);
					TokenNameFinderModel entityModel = new TokenNameFinderModel(ModelFile);
					NameFinderME namefinder = new NameFinderME(entityModel);
				

		
				
				
					String tokens[] = tokenizer.tokenize(sentence);
					Span nameSpans[] = namefinder.find(tokens);
					double[] Probability = namefinder.probs(nameSpans);
					for(int i=0;i<nameSpans.length;i++)
					{
						System.out.println("Span: "+nameSpans[i].toString());
						System.out.println("Entity: "+tokens[nameSpans[i].getStart()]);
						System.out.println("Probability: " + Probability[i]);
					}
					
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