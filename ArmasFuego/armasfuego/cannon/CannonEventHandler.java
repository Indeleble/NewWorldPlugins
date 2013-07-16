package armasfuego.cannon;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import armasfuego.ArmasFuego;

public class CannonEventHandler implements Listener{

	@SuppressWarnings("unused")
	private ArmasFuego plugin;

	public CannonEventHandler(ArmasFuego plugin) {
		this.plugin = plugin;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) { // CA�ON
		if((cmd.getName().equalsIgnoreCase("canon")) || (cmd.getName().equalsIgnoreCase("ca"))){

        	Player player = (Player) sender;

			if (!(sender instanceof Player)) {
				sender.sendMessage("este comando solo puede ser usado por un usuario.");
			}else if(args.length==0){
				player.sendMessage("Usa /canon usar/salir/limpiar/cargar/disparar/ayuda");	
			}else if (args.length == 1){

		        if ((args[0].equalsIgnoreCase("usar"))){
		        	player.sendMessage("Te preparas para usar el ca�on");
		        	//Aqui llamaa a congelar
		        	// checkear que el ca�on este delante
		        }else if((args[0].equalsIgnoreCase("salir"))){
		        	player.sendMessage("Dejas de usar el ca�on");
		        	// aqui se llama a dejar de usar el ca�on
		        }else if((args[0].equalsIgnoreCase("limpiar"))){
		        	player.sendMessage("Utilizas el palo para llenar el ca�on de polvora");
		        	// limpiado true
		        }else if((args[0].equalsIgnoreCase("cargar"))){
		        	player.sendMessage("Te preparas para usar el ca�on");
		        	
		        	// if limpiado == true{
		        	// cargado true
		        	// }else{ return false player.sendmessage("tienes que limpiar el ca�on primero"): }

		        }else if((args[0].equalsIgnoreCase("disparar"))){
		        	player.sendMessage("disparas el ca�on, no te muevas o dejar�s de disparar");
		        	
		        	// if cargado == true{
		        	// checkear si se mueve, si se mueve cancelar el evento
		        	// checkear si no se mueve, si no se mueve wait() un tiempo y lanzar una fireball hacia donde mira, setear cargado y limpio a false.
		        	// }else{ return false player.sendmessage("tienes que cargar el ca�on primero"): }
		        	
		        	
		        }else if((args[0].equalsIgnoreCase("ayuda"))){
		        	player.sendMessage("usa /canon usar, para colocarte en el ca�on para usarlo, siempre mirando hacia el lado del objetivo.");
		        	player.sendMessage("usa /canon salir, para dejar de usar el ca�on");
		        	player.sendMessage("usa /canon limpiar, con una tabla en la mano y polvora en el inventario lo utilizas para colocar la polvora en el ca�on");
		        	player.sendMessage("usa /canon cargar, con una bola de ca�on en la mano la colocas dentro del ca�on para dispararla");
		        	player.sendMessage("usa /canon disparar, apuntando al objetivo disparas el ca�on, si te mueves se cancela el evento y tienes que volver a disparar de nuevo.");
		        }else{
		        	player.sendMessage("Comando desconocido");
		        }
			}
			return true;
		}
		return false;
	}
}

