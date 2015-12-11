public class PUPIL
{
    private String fName;
    private String sName;
    private int TopMark;

    public PUPIL()
    {
        fName = "";
        sName = "";
        TopMark = 0;
    } 

    public void readPupilDetails(String dataItems)
    {
        String[] rowItems = dataItems.split(",");
        fName = rowItems[0];
        sName = rowItems[1];
        TopMark = Integer.parseInt(rowItems[2]);
    }

    public String writeDetails()
    {
        String pupilData = "";
        pupilData = pupilData.concat(fName);
        pupilData = pupilData.concat(",");
        pupilData = pupilData.concat(sName);
        pupilData = pupilData.concat(",");
        pupilData = pupilData.concat(Integer.toString(TopMark));
        return pupilData;
    }

    public float getTopMark()
    {
        return TopMark;
    }


    public void displayDetails()
    {
        System.out.print(" The pupil achieving this mark was: " + fName + " " + sName);
        System.out.print(" Their mark was: " + TopMark);
        System.out.println();
    }
}