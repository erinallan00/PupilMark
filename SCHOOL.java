import javax.swing.JOptionPane;
import java.io.*;
public class SCHOOL
{
   private PUPIL pupillist[];
   int noOfPupils;
   FILEREADCSV scoreFile;
   public SCHOOL()
   {
       scoreFile = new FILEREADCSV();
   }

   public void processPupils() throws IOException

   {
       setUpPupilList();
       countOKTopMark();
   }
   
   public void setUpPupilList() throws IOException

   {
       System.out.println("School top mark update");
       System.out.println("** Preparing to read data file.");
       String[] dataRows = scoreFile.readCSVtable();
       noOfPupils = dataRows.length;
       System.out.println("** " + noOfPupils + " rows read.\n\n");
    }

  public void countOKTopMark()
  {
       // placeholder
  }


}