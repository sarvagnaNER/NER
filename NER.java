import java.util.*;
import java.io.*;
import edu.stanford.nlp.ie.crf.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.util.*;
import edu.stanford.nlp.sequences.*;

class NER
{
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		String modelLocation = "english.all.3class.distsim.crf.ser.gz";	
		CRFClassifier<CoreLabel> classifier = CRFClassifier.getClassifierNoExceptions(modelLocation);
		System.out.println("Enter a String");
		String sentence = sc.nextLine();
		List<List<CoreLabel>> entityList = classifier.classify(sentence);
		//DocumentReaderAndWriter<CoreLabel> readerAndWriter = classifier.makePlainTextReaderAndWriter();
		//classifier.classifyAndWriteAnswersKBest(modelLocation, 10, readerAndWriter);
		for(List<CoreLabel> tempList:entityList)
		{
			for(CoreLabel cl:tempList)
			{
				String word = cl.word();
				String category = cl.get(CoreAnnotations.AnswerAnnotation.class);
				if(!"O".equals(category))
				{
					System.out.println(word+" : "+category);
					//classifier.printProbs(modelLocation, readerAndWriter);
				}
			}
		}
	}
}