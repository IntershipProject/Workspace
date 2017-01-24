
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.jnetpcap.protocol.tcpip.Udp;
import org.jnetpcap.protocol.network.Arp;
import org.jnetpcap.packet.JHeader;
import org.jnetpcap.packet.JHeaderPool;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.PcapSockAddr;

public class NetworkPacket {

	private static String sourceIP;
	private static int sourcePort;
	private static String destIP;
	private static int destPort;
	private static String description;

	// DatabaseHandler hand = new DatabaseHandler();
	public NetworkPacket(PcapPacket packet) {

		System.out.println(
				"\n-------------------------------------------------------------------------------------------------------\n\n\n");
		Ip4 ip = new Ip4();
		Tcp tcp = new Tcp();
		Udp udp = new Udp();
		byte[] sIP = new byte[4];
		byte[] dIP = new byte[4];
		// String sourceIP = "";
		// String destIP = "";
		if (packet.hasHeader(ip)) {
			description = ip.getDescription();
			System.out.println("***********************\n    " + description + "\n***********************\n");
			sIP = packet.getHeader(ip).source();
			sourceIP = FormatUtils.ip(sIP);
			dIP = packet.getHeader(ip).destination();
			destIP = FormatUtils.ip(dIP);
			System.out.println("*  " + sourceIP + "  *  " + destIP);
			System.out.println();
			System.out.println("Source IP= " + sourceIP);
			System.out.println("Destination IP= " + destIP);
			System.out.println();
			if (packet.hasHeader(tcp)) {
				findPortName("Source", tcp.source(), "TCP");

				findPortName("Destination", tcp.destination(), "TCP");
			} else
				System.out.println("No TCP Protocol......");
			if (packet.hasHeader(udp)) {
				findPortName("Source", udp.source(), "UDP");
				findPortName("Destination", udp.destination(), "UDP");
			} else
				System.out.println("No UDP Protocol......");
		} else
			System.out.println("No IP......");

		System.out.println(
				"\n\n\n------------------------------------------------------------------------------------------------------");

	}

	private static void findPortName(String type, int port, String name) {
		System.out.println(type + " " + name + " number= " + port);

		if (type.equals("Source")) {
			sourcePort = port;
		} else if (type.equals("Destination")) {
			destPort = port;
		} else {
			System.out.println("Incorrect port type.");
		}

		if (port == 80) {
			System.out.println(type + " " + name + " protocol name=  HTTP ");
		} else if (port == 23) {
			System.out.println(type + " " + name + " protocol name= Telnet");
		} else if (port == 22) {
			System.out.println(type + " " + name + " protocol name= SSH ");
		} else if (port == 25) {
			System.out.println(type + " " + name + " protocol name= SMTP ");
		} else if (port == 53) {
			System.out.println(type + " " + name + " protocol name= DNS ");
		} else if (port == 110) {
			System.out.println(type + " " + name + " protocol name= POP3 ");
		} else if (port == 546) {
			System.out.println(type + " " + name + " protocol name= DHCP ");
		} else if (port == 443) {
			System.out.println(type + " " + name + " protocol name= HTTPS ");
		} else if (port == 546) {
			System.out.println(type + " " + name + " protocol name= DHCP ");
		} else if (port >= 48620 && port <= 49150) {
			System.out.println(type + " " + name + " protocol name= Unassigned");
		} else {
			System.out.println(type + " " + name + " protocol= Unknown");
		}
	}

	/*
	 * public void DB(){
	 * 
	 * hand.insertElement(sourceIP, destIP, description, sourcePort, destPort);
	 * } public void findinDB(){ hand.findElement(sourceIP); }
	 */
	public static String getSourceIP() {
		return sourceIP;
	}

	public static void setSourceIP(String sourceIP) {
		NetworkPacket.sourceIP = sourceIP;
	}

	public static int getSourcePort() {
		return sourcePort;
	}

	public static void setSourcePort(int sourcePort) {
		NetworkPacket.sourcePort = sourcePort;
	}

	public static String getDestIP() {
		return destIP;
	}

	public static void setDestIP(String destIP) {
		NetworkPacket.destIP = destIP;
	}

	public static int getDestPort() {
		return destPort;
	}

	public static void setDestPort(int destPort) {
		NetworkPacket.destPort = destPort;
	}

}
