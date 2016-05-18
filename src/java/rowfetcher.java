/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class rowfetcher {
    public static void main(String[] args) throws IOException, Exception {
        File input=new File("F:\\java\\crawler\\src\\crawler\\pattern.html");
        Document doc=org.jsoup.Jsoup.parse(input,"UTF-8");
        //System.out.println(doc);
        //Document doc=org.jsoup.Jsoup.connect("https://en.wikipedia.org/wiki/Computer").get();//this is to get the entire page
       // org.jsoup.Jsoup.parse(String html);// to correct any improper code in html
      Elements link=doc.select("tr");
       
      //System.out.println(link1);
      //System.out.println(link);
       org.jsoup.nodes.Element e1=link.first(); 
      String querrying=e1.text();
      StringTokenizer st=new StringTokenizer(querrying);
      ArrayList<String> al=new ArrayList<String>();
      while(st.hasMoreTokens())
      {
          al.add(st.nextToken());
      }
      System.out.println(al);
      String query ="CREATE TABLE cloud ("+al.get(0)+" VARCHAR(70),"+al.get(1)+" VARCHAR(300),"+al.get(2)+" VARCHAR(20),"+al.get(3)+" VARCHAR(50),"+al.get(4)+" VARCHAR(50),"+al.get(5)+" VARCHAR(50),"+al.get(6)+" VARCHAR(50),"+al.get(7)+" VARCHAR(50))";
     
      System.out.println(query);
      try{
           querryrunner.createtable(query);
      
      
      
      }
      catch(SQLException e)
      {
          System.out.println(e.getStackTrace());
      }
      int c=0;
      ArrayList<String> rows=new ArrayList<String>();
      for(org.jsoup.nodes.Element e2:link)
      { 
          if(c==0)
      {
          c=1;
          continue;
      }
      rows.add(e2.text());
          System.out.println(e2.text());
       //   System.out.print(e1.text());
       //1 System.out.println();
      }
      System.out.println(rows);
      querryrunner.entryofrow(rows);
      System.out.println(rows);
      
      
     //  System.out.println(text);
            //System.out.println(doc);
 /*String relHref=link.attr("href");
   System.out.println(relHref);*/
        //System.out.println(doc);
    } 
}
