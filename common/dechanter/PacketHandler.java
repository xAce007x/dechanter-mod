package dechanter;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager,
			Packet250CustomPayload packet, Player player) {
		if (packet.channel.equals("Dechanter_Mod")) {
			handleDechanterPacket(packet);
		}
	}

	private void handleDechanterPacket(Packet250CustomPayload packet) {
		DataInputStream inputStream = new DataInputStream(
				new ByteArrayInputStream(packet.data));

		int int1 = 1;
		int int2 = 2;

		try {
			int1 = inputStream.readInt();
			int2 = inputStream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(int1 + " " + int2);
	}

}
