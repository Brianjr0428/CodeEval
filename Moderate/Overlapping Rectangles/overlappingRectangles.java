import java.io.*;

public class overlappingRectangles{
	public static void main (String[] args){
		try{
			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line; 
			String[] points;
			while ((line = in.readLine()) != null){	
				points=line.split(",");
				int[] upperLeft={Integer.parseInt(points[0]),Integer.parseInt(points[1])};
				int[] upperRight={Integer.parseInt(points[2]),Integer.parseInt(points[1])};
				int[] lowerLeft={Integer.parseInt(points[0]),Integer.parseInt(points[3])};
				int[] lowerRight={Integer.parseInt(points[2]),Integer.parseInt(points[3])};
				int[] xRange={Integer.parseInt(points[4]),Integer.parseInt(points[6])};
				int[] yRange={Integer.parseInt(points[7]),Integer.parseInt(points[5])};
				if(isOverlap(upperLeft,xRange,yRange)||isOverlap(upperRight,xRange,yRange)||isOverlap(lowerLeft,xRange,yRange)||isOverlap(lowerRight,xRange,yRange))
					System.out.println("True");
				else
					System.out.println("False");
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
	public static boolean isOverlap(int[] point, int[] xRange,int[] yRange){
		return(point[0]>=xRange[0]&&point[0]<=xRange[1]&&point[1]>=yRange[0]&&point[1]<=yRange[1]);
	}
}
