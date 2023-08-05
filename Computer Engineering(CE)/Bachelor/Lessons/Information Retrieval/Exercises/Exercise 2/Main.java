// 𝕄𝕠𝕤𝔽𝕒𝕫𝕝𝕚
// Searcher
// This app created in 22 November 2021

//import libraries
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;


//main class
public class Main {

    public static void main(String[] args) throws IOException {
        // 0. Specify the analyzer for tokenizing text.
        //    The same analyzer should be used for indexing and searching
        StandardAnalyzer analyzer = new StandardAnalyzer();

        // 1. create the index
        Directory index = new RAMDirectory();

        IndexWriterConfig config = new IndexWriterConfig(analyzer);



        IndexWriter w = new IndexWriter(index,config);


        String[] list = new String[2];
        ArrayList<String> textFiles = new ArrayList<>();
//        String list2= new String();
        ArrayList<String> stopWordsList = new ArrayList<>();

        stopWordsList.add(" not ");
        stopWordsList.add(" this ");
        stopWordsList.add(" is ");
        stopWordsList.add(" is,");
        stopWordsList.add(" and ");
        stopWordsList.add(" the ");
        stopWordsList.add(" are ");
        stopWordsList.add(" of ");
        stopWordsList.add(" a ");
        stopWordsList.add(" in ");
        stopWordsList.add(" to ");
        stopWordsList.add(" from ");
        stopWordsList.add(" on ");
        stopWordsList.add(" with ");
        stopWordsList.add(" be ");

        for (int i = 1; i <= 314; i++) {
            //System.out.println(i + "\t" + fileRead(i));
            //addDoc(w, fileRead(i));
            String address = "E:\\SearchingData_Database\\";

            //File f = new File(address + String.valueOf(index) + ".txt");
            if(new File(address + String.valueOf(i) + ".txt").isFile()) {
                list = fileRead(i);
               // System.out.println(list1);
                for (int j = 0; j < stopWordsList.size(); j++) {
                    list[0] = list[0].replace(stopWordsList.get(j)," ");
                }
                // System.out.println(list1);
                addDoc(w,list[0]);
                textFiles.add(list[1]);
               //System.out.println(list1);

            }
        }


        /*addDoc(w, "Lucene in Action");
        addDoc(w, "Lucene for Dummies" );
        addDoc(w, "Managing Gigabytes");
        addDoc(w, "The Art of Computer Science");*/
        w.close();

        // 2. query
        String inputSearch = "Conformal";
        String[] queries = inputSearch.toLowerCase().split(" ");



        if(queries.length == 1) {
            String search1 = queries[0];
            String search = search1;


            if (search.length() > 5) {
                String temp = "";
                for (int i = 0; i < 5; i++) {
                    temp = temp + search.charAt(i);
                }
                search = temp;
            }
            search = search.toLowerCase();
            String queryString = args.length > 0 ? args[0] : search;


            // the "title" arg specifies the default field to use
            // when no field is explicitly specified in the query.
            Query query = null;
            try {
                String[] fields = {"title"};
                query = new MultiFieldQueryParser(fields, analyzer).parse(queryString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // 3. search
            int hitsPerPage = 20;
            IndexReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, 10);
            searcher.search(query, collector);
            ScoreDoc[] hits = collector.topDocs().scoreDocs;

            // 4. display results
            System.out.println("--------------***********--------------");
            System.out.println("Found " + search1 + " " + hits.length + " hits:" + "\n");


            for (int i = 0; i < hits.length; ++i) {
                int docId = hits[i].doc;
                Document d = searcher.doc(docId);
                //System.out.println((i + 1) + ". " +  "\t" + docId + "\t" + d.get("title"));
                System.out.println((i + 1) + "." + "\t" + docId);
                System.out.println(textFiles.get(docId) + "\n");
                //System.out.println((i + 1) + ". " +  "\t" + docId );
            }

            System.out.println("--------------***********--------------");

            // reader can only be closed when there
            // is no need to access the documents any more.
            reader.close();

        }else if(queries.length == 2){

            String search1 = queries[1];
            String search = search1;


            if (search.length() > 5) {
                String temp = "";
                for (int i = 0; i < 5; i++) {
                    temp = temp + search.charAt(i);
                }
                search = temp;
            }
            search = search.toLowerCase();
            String queryString = args.length > 0 ? args[0] : search;


            // the "title" arg specifies the default field to use
            // when no field is explicitly specified in the query.
            Query query = null;
            try {
                String[] fields = {"title"};
                query = new MultiFieldQueryParser(fields, analyzer).parse(queryString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            // 3. search
            int hitsPerPage = 20;
            IndexReader reader = DirectoryReader.open(index);
            IndexSearcher searcher = new IndexSearcher(reader);
            TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, 10);
            searcher.search(query, collector);
            ScoreDoc[] hits = collector.topDocs().scoreDocs;

            // 4. display results
            System.out.println("--------------***********--------------");
            System.out.println("Found Not " + search1 + " " + hits.length + " hits:" + "\n");


            for (int i = 0; i < hits.length; ++i) {
                if(i != hits[i].doc) {
                    int docId = i;
                    Document d = searcher.doc(docId);
                    //System.out.println((i + 1) + ". " +  "\t" + docId + "\t" + d.get("title"));
                    System.out.println((i + 1) + "." + "\t" + docId);
                    System.out.println(textFiles.get(docId) + "\n");
                    //System.out.println((i + 1) + ". " +  "\t" + docId );
                }
            }

            System.out.println("--------------***********--------------");

            // reader can only be closed when there
            // is no need to access the documents any more.
            reader.close();
        }
        else if(queries.length == 3){



            if(queries[1].equals("or")){

                String search1 = queries[0];
                String search = search1;


                if (search.length() > 5) {
                    String temp = "";
                    for (int i = 0; i < 5; i++) {
                        temp = temp + search.charAt(i);
                    }
                    search = temp;
                }
                search = search.toLowerCase();
                String queryString = args.length > 0 ? args[0] : search;


                // the "title" arg specifies the default field to use
                // when no field is explicitly specified in the query.
                Query query = null;
                try {
                    String[] fields = {"title"};
                    query = new MultiFieldQueryParser(fields, analyzer).parse(queryString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // 3. search
                int hitsPerPage = 20;
                IndexReader reader = DirectoryReader.open(index);
                IndexSearcher searcher = new IndexSearcher(reader);
                TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, 10);
                searcher.search(query, collector);
                ScoreDoc[] hits = collector.topDocs().scoreDocs;

                // 4. display results
               // System.out.println("--------------***********--------------");
                //System.out.println("Found " + search1 + " " + hits.length + " hits:" + "\n");

                LinkedList<Integer> doc1 = new LinkedList<>();

                for (int i = 0; i < hits.length; ++i) {
                    int docId = hits[i].doc;
                    doc1.add(docId);
                    Document d = searcher.doc(docId);
                    //System.out.println((i + 1) + ". " +  "\t" + docId + "\t" + d.get("title"));
              //      System.out.println((i + 1) + "." + "\t" + docId);
               //     System.out.println(textFiles.get(docId) + "\n");
                    //System.out.println((i + 1) + ". " +  "\t" + docId );
                }

                //System.out.println("--------------***********--------------");


                String search3 = queries[2];
                String search2 = search3;


                if (search2.length() > 5) {
                    String temp = "";
                    for (int i = 0; i < 5; i++) {
                        temp = temp + search2.charAt(i);
                    }
                    search = temp;
                }
                search = search2.toLowerCase();
                String queryString2 = args.length > 0 ? args[0] : search;


                // the "title" arg specifies the default field to use
                // when no field is explicitly specified in the query.
                Query query2 = null;
                try {
                    String[] fields2 = {"title"};
                    query2 = new MultiFieldQueryParser(fields2, analyzer).parse(queryString2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // 3. search
                int hitsPerPage2 = 20;
                IndexReader reader2 = DirectoryReader.open(index);
                IndexSearcher searcher2 = new IndexSearcher(reader2);
                TopScoreDocCollector collector2 = TopScoreDocCollector.create(hitsPerPage2, 10);
                searcher2.search(query2, collector2);
                ScoreDoc[] hits2 = collector2.topDocs().scoreDocs;

                // 4. display results
             //   System.out.println("--------------***********--------------");
               // System.out.println("Found " + search2 + " " + hits2.length + " hits:" + "\n");

                LinkedList<Integer> doc2 = new LinkedList<>();

                for (int i = 0; i < hits2.length; ++i) {
                    int docId2 = hits2[i].doc;
                    doc2.add(docId2);
                    Document d2 = searcher2.doc(docId2);
                    //System.out.println((i + 1) + ". " +  "\t" + docId + "\t" + d.get("title"));
                  //  System.out.println((i + 1) + "." + "\t" + docId2);
                   // System.out.println(textFiles.get(docId2) + "\n");
                    //System.out.println((i + 1) + ". " +  "\t" + docId );
                }

                //System.out.println("--------------***********--------------");

                // reader can only be closed when there
                // is no need to access the documents any more.
                reader2.close();


                int maxSize = 0;
                LinkedList<Integer> ans = new LinkedList<>();

                for (int i = 0; i < doc1.size(); i++) {
                    ans.add(doc1.get(i));
                }

                for (int i = 0; i < doc2.size(); i++) {
                    boolean flag = false;
                    for (int j = 0; j < doc1.size(); j++) {
                        if(doc1.get(j) == doc2.get(i)){
                            flag = true;
                        }
                    }
                    if(flag == false){
                        ans.add(doc2.get(i));
                    }
                }


                System.out.println("--------------***********--------------");
                for (int i = 0; i < ans.size(); ++i) {
                    //System.out.println((i + 1) + ". " +  "\t" + docId + "\t" + d.get("title"));
                    System.out.println((i + 1) + "." + "\t" + ans.get(i));
                    System.out.println(textFiles.get(ans.get(i)) + "\n");
                    //System.out.println((i + 1) + ". " +  "\t" + docId );
                }
                System.out.println("--------------***********--------------");




            }else if(queries[1].equals("and")) {

                String search1 = queries[0];
                String search = search1;


                if (search.length() > 5) {
                    String temp = "";
                    for (int i = 0; i < 5; i++) {
                        temp = temp + search.charAt(i);
                    }
                    search = temp;
                }
                search = search.toLowerCase();
                String queryString = args.length > 0 ? args[0] : search;


                // the "title" arg specifies the default field to use
                // when no field is explicitly specified in the query.
                Query query = null;
                try {
                    String[] fields = {"title"};
                    query = new MultiFieldQueryParser(fields, analyzer).parse(queryString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // 3. search
                int hitsPerPage = 20;
                IndexReader reader = DirectoryReader.open(index);
                IndexSearcher searcher = new IndexSearcher(reader);
                TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, 10);
                searcher.search(query, collector);
                ScoreDoc[] hits = collector.topDocs().scoreDocs;

                // 4. display results
                // System.out.println("--------------***********--------------");
                //System.out.println("Found " + search1 + " " + hits.length + " hits:" + "\n");

                LinkedList<Integer> doc1 = new LinkedList<>();

                for (int i = 0; i < hits.length; ++i) {
                    int docId = hits[i].doc;
                    doc1.add(docId);
                    Document d = searcher.doc(docId);
                    //System.out.println((i + 1) + ". " +  "\t" + docId + "\t" + d.get("title"));
                    //      System.out.println((i + 1) + "." + "\t" + docId);
                    //     System.out.println(textFiles.get(docId) + "\n");
                    //System.out.println((i + 1) + ". " +  "\t" + docId );
                }

                //System.out.println("--------------***********--------------");


                String search3 = queries[2];
                String search2 = search3;


                if (search2.length() > 5) {
                    String temp = "";
                    for (int i = 0; i < 5; i++) {
                        temp = temp + search2.charAt(i);
                    }
                    search = temp;
                }
                search = search2.toLowerCase();
                String queryString2 = args.length > 0 ? args[0] : search;


                // the "title" arg specifies the default field to use
                // when no field is explicitly specified in the query.
                Query query2 = null;
                try {
                    String[] fields2 = {"title"};
                    query2 = new MultiFieldQueryParser(fields2, analyzer).parse(queryString2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // 3. search
                int hitsPerPage2 = 20;
                IndexReader reader2 = DirectoryReader.open(index);
                IndexSearcher searcher2 = new IndexSearcher(reader2);
                TopScoreDocCollector collector2 = TopScoreDocCollector.create(hitsPerPage2, 10);
                searcher2.search(query2, collector2);
                ScoreDoc[] hits2 = collector2.topDocs().scoreDocs;

                // 4. display results
                //   System.out.println("--------------***********--------------");
                // System.out.println("Found " + search2 + " " + hits2.length + " hits:" + "\n");

                LinkedList<Integer> doc2 = new LinkedList<>();

                for (int i = 0; i < hits2.length; ++i) {
                    int docId2 = hits2[i].doc;
                    doc2.add(docId2);
                    Document d2 = searcher2.doc(docId2);
                    //System.out.println((i + 1) + ". " +  "\t" + docId + "\t" + d.get("title"));
                    //  System.out.println((i + 1) + "." + "\t" + docId2);
                    // System.out.println(textFiles.get(docId2) + "\n");
                    //System.out.println((i + 1) + ". " +  "\t" + docId );
                }

                //System.out.println("--------------***********--------------");

                // reader can only be closed when there
                // is no need to access the documents any more.
                reader2.close();


                int maxSize = 0;
                LinkedList<Integer> ans = new LinkedList<>();


                for (int i = 0; i < doc2.size(); i++) {
                    boolean flag = false;
                    for (int j = 0; j < doc1.size(); j++) {
                        if (doc1.get(j) == doc2.get(i)) {
                            flag = true;
                            ans.add(doc1.get(j));
                        }
                    }

                }


                System.out.println("--------------***********--------------");
                for (int i = 0; i < ans.size(); ++i) {
                    //System.out.println((i + 1) + ". " +  "\t" + docId + "\t" + d.get("title"));
                    System.out.println((i + 1) + "." + "\t" + ans.get(i));
                    System.out.println(textFiles.get(ans.get(i)) + "\n");
                    //System.out.println((i + 1) + ". " +  "\t" + docId );
                }
                System.out.println("--------------***********--------------");


            }

        }
    }

    private static void addDoc(IndexWriter w, String title) throws IOException {
        Document doc = new Document();
        doc.add(new TextField("title", title, Field.Store.YES));

        w.addDocument(doc);
    }


    public static String[] fileRead(int index) throws IOException {
        // File path is passed as parameter

        String address = "E:\\SearchingData_Database\\";

        File file = new File(address + String.valueOf(index) + ".txt");

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br = null;

        if(new FileReader(file) != null) {
             br = new BufferedReader(new FileReader(file));
        }

        // Declaring a string variable
        String st;
        String contain="";
        String contain2="";
        int flag = 0, lineZero = 0;
        // Consition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null) {
            // Print the string
            if(st.contains("###")){
                flag++;
            }

            if(flag == 1 && lineZero != 0) {
//                PorterStemmer stem = new PorterStemmer();
//                stem.setCurrent(contain);
//                stem.stem();
//                contain = stem.getCurrent();

                contain2 = contain2 + st;
                String[] words = st.split(" ");
                ArrayList<String> wordsLine = new ArrayList<>();
                for (int i = 0; i < words.length; i++) {
                    if(words[i].length() > 5){
                        String temp = "";
                        for (int j = 0; j < 5; j++) {
                               temp = temp + words[i].charAt(j);
                        }
                        wordsLine.add(temp);
                    }else{
                        wordsLine.add(words[i]);
                    }
                }
                for (int i = 0; i < wordsLine.size(); i++) {
                    contain = contain + wordsLine.get(i).toLowerCase() + " ";
                }
            }
            lineZero++;
        }

        String[] a = new String[2];
        a[0] = contain;
        a[1] = contain2;
        return a;

    }

}