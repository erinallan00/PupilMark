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
       pupillist = new PUPIL[noOfPupils];
       for  (int i = 0; i < noOfPupils; i++) {
            pupillist[i] = new PUPIL();
            pupillist[i].readPupilDetails(dataRows[i+1]);
       }
    }

  public void countOKTopMark()
  {
       for (int i = 0; i < noOfPupils; i++)
       {
 		if ((pupillist[i].getTopMark() > 50))
 		{
 		    pupillist[i].displayDetails();
  		}
 	}

  }


}