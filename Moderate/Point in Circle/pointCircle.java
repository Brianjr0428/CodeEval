import java.io.*;

public class pointCircle{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] content;
			String[] center;
			String[] radius;
			String[] points;
			double r;
			double centerX;
			double centerY;
			double pointX;
			double pointY;
			while ((line = in.readLine()) != null){
				content=line.split("; ");
				center=content[0].split(" ");
				centerX=Double.parseDouble(center[1].substring(1,center[1].length()-1));
				centerY=Double.parseDouble(center[2].substring(0,center[2].length()-1));
				radius=content[1].split(" ");
				r=Double.parseDouble(radius[1]);
				points=content[2].split(" ");
				pointX=Double.parseDouble(points[1].substring(1,points[1].length()-1));
				pointY=Double.parseDouble(points[2].substring(0,points[2].length()-1));
				System.out.println(Math.sqrt(Math.pow(pointX-centerX,2)+Math.pow(pointY-centerY,2))<=r);
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
