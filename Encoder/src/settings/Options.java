package settings;

import java.awt.Color;
import java.io.*;

public class Options {
	
	// 路径设定区
	// Area Of Paths
	private static String PATHPrefix = "E:\\NET-Program-Output\\v0.2.00\\";
	public static String INPUT_FILENAME = PATHPrefix + "NetIn.G24";
	public static String ENC_OUTPUTPATH = PATHPrefix + "EncResult\\";
	public static String ENC_OUTMP4NAME = "Enc00Out.mp4";
	public static String FFMPEGPATH = "D:\\Program-Folders\\ffmpeg\\bin\\ffmpeg.exe";
	// 由static {}块进行进一步，如果内存盘Q盘存在，会自动修改目录至Q盘
	static {
		File Q = new File("Q:/");
		if (Q.exists()) {
			PATHPrefix = "Q" + PATHPrefix.substring(1);
			ENC_OUTPUTPATH = "Q" + ENC_OUTPUTPATH.substring(1);
			File Q_OUT = new File(ENC_OUTPUTPATH);
			if (!Q_OUT.exists())
				Q_OUT.mkdirs();
			System.out.println("RAMDisk directory is created: "+PATHPrefix);
		}
	}
	
	// 色彩编码集设定区
	// Area Of Color Set
	public static Color[] colorset = {Color.red, Color.black, Color.green, Color.blue}; 
	
	// 视频参数常量设置区
	// Area Of Video Consts
	public static int FPS = 15;
	
	// 单帧参数常量设定区
	// Area Of Single Frame Consts
	/**每个Cell格子的边长*/
	public static int cellsize = 10;
	
	/**每个Block方块的边框宽度*/
	public static int border = 4;
	
	/**每个Block在X方向的列数*/
	public static int xsplit  = 30;
	/**每个Block在Y方向的行数*/
	public static int ysplit  = 34;
	
	/**第一个Block方块左上角的X坐标*/
	public static int xlocation = 16;
	/**第一个Block方块左上角的Y坐标*/
	public static int ylocation = 10;
	
	/**各个Block方块左上角坐标的X差值*/
	public static int xspan = 2*border + xsplit*cellsize + 8;
	/**各个Block方块左上角坐标的Y差值*/
	public static int yspan = 2*border + ysplit*cellsize + 8;
	
	/**4字节容量 表示文件长度（按字节计）的偏移量*/
	public static int offset = 16;
	/**checksum size 校验和长度	4字节容量 共计16*2bit格子*/
	public static int csSize = 16;
	/**frame id size 帧编号 3个一循环 2字节容量 共计8*2bit格子*/
	public static int frmIDSize = 8;
	public static int[] frmidlist = {0x0, 0xAAAA, 0xFFFF};
	//public static int[] frmidlist = {0x2CB2, 0xB2CB, 0xCB2C};
	
	/**block capacity 方块容量 每帧能够容纳多少个2bit格子*/
	public static int blockCap
		= Options.xsplit * Options.ysplit;
	/**frame capacity 帧容量 每帧能够容纳多少个2bit格子*/
	public static int frameCap
		= 18 * blockCap;
	
	//Out Of Date
	public static String OUTPUTPATH = ENC_OUTPUTPATH;
}
