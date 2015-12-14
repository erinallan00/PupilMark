import javax.swing.JOptionPane;
import java.io.*;
public class SCHOOL
{
    private PUPIL pupillist[];
    int noOfPupils;
    FILEREADCSV scoreFile;
    FILEWRITECSV resultFile;
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
            pupillist[i].readPupilDetails(dataRows[i]);
        }
    }

    public void countOKTopMark() throws IOException
    {
        String fileContent = "";
        int maxDataPosition = 0;
        for  (int i = 1; i < noOfPupils; i++) {
            if (pupillist[i].getTopMark() > pupillist[maxDataPosition].getTopMark()) {
                // update the position of the best value
                maxDataPosition = i;
            }
        }

        //display results: position and the best (max) value
        System.out.print("Highest Mark was found at position: " + maxDataPosition );
        pupillist[maxDataPosition].displayDetails();
        System.out.println();
        System.out.println("** File written and closed.");
        fileContent = fileContent.concat(pupillist[maxDataPosition].writeDetails());
        if (maxDataPosition>1)
        {
            fileContent = fileContent.concat("\n");
            resultFile.writeCSVtable(fileContent);
        }

    }
} 