import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;



public class StopWords {
    private String[] defaultStopWords = {"i", "a", "about", "an","are", "as", "at", "be", "by", "com", "for", "from", "how","in", "is", "it", "of", "on", "or", "that", "the", "this", "to", "was", "what", "when", "where", "who", "will", "with"};
    private static HashSet stopWords  = new HashSet(); 
    
    public StopWords()
    {    
     	stopWords.addAll(Arrays.asList(defaultStopWords));
    }
	public StopWords(String fileName) 
	{
	    try 
	    {
	    	 BufferedReader bufferedreader =new BufferedReader(new FileReader(fileName));
	    	 while (bufferedreader.ready()) 
	    	 	{            
	    	 		stopWords.add(bufferedreader.readLine());        
	    	 	}    
	    } 
	    catch (IOException ex) 
	    {        
	    	ex.printStackTrace();    
	    } 
	}

	public void addStopWord(String word) 
	{    
		stopWords.add(word); 
	}

	public String[] removeStopWords(String[] words) 
	{    
		ArrayList<String> tokens =new ArrayList<String>(Arrays.asList(words));    
		for (int i = 0; i < tokens.size(); i++) 
			{        
				if (stopWords.contains(tokens.get(i))) 
					{            
						tokens.remove(i);        
					}    
			}    
			return (String[]) tokens.toArray(new String[tokens.size()]); 
	} 
} 



class Normalization
{
	public static void main(String[] args) {
		StopWords stopWords = new StopWords();
		SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE; 
		String paragraph = "A simple approach is to create a class "+"to hold and remove stopwords.";
		String tokens[] = simpleTokenizer.tokenize(paragraph); 
		String list[] = stopWords.removeStopWords(tokens); 
		for (String word : list) 
			{
			    System.out.println(word);
			} 
	}
}