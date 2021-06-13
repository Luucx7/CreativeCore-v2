package me.luucx7.creativecore.v2.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuizCommandExecutor {

    private final CommandSender sender;
    private final String[] args;
    private final Player player;

    public QuizCommandExecutor(CommandSender sender, String[] args) {
        this.sender = sender;
        this.args = args;

        if (sender instanceof Player) {
            this.player = (Player) sender;
        } else player = null;

        if (args.length == 0) {
            help();
            return;
        }

        switch (args[0]) {
            case "":
            case "1":
            default:
                help();
        }
    }

    private void help() {
        sender.sendMessage("§8§l§m--------§r§8§l>§b§l Quiz §8§l<§r§8§l§m--------");
        sender.sendMessage(" ");
        sender.sendMessage("§9/resposta <argumento> §3§l| §bTente responder ao quiz!");
        if (sender.hasPermission("quiz.setup")) {
            sender.sendMessage(" ");
            sender.sendMessage("§3§lCriação de Quiz:");
            sender.sendMessage("§c/quiz criar §3§l| §bCria uma nova instância de quiz");
            sender.sendMessage("§c/quiz resposta <resposta> §3§l| §bDefine a resposta do quiz.");
            sender.sendMessage("§c/quiz acertarEncerrar §3§l| §bDefine se o quiz termina ao responder certo. §4Padrão: §2§lVerdadeiro");
            sender.sendMessage("§c/quiz tempomax <Número> §3§l| §bDefine a duração máxima do quiz.");
            sender.sendMessage("§c/quiz annDelay <Número> §3§l| §bDefine o delay de anúncio do quiz (0 = Sem anúncios automáticos) §4Padrão: §e0");
            sender.sendMessage(" ");
            sender.sendMessage("§3§lPrêmio:");
            sender.sendMessage("§c/quiz premio item §3§l| §bAdiciona o item na mão como prêmio do quiz.");
            sender.sendMessage("§c/quiz premio money <Valor> §3§l| §bDefine o prêmio em dinheiro do quiz.");
            sender.sendMessage("§c/quiz premio todosGanham §3§l| §bDefine se todos os jogadores ganham os prêmios. §4Incompatível com: acertarEncerrar");
            sender.sendMessage(" ");
            sender.sendMessage("§3§lGerais:");
            sender.sendMessage("§c/quiz ann §3§l| §bAnuncia o quiz");
            sender.sendMessage("§c/quiz encerrar [Silencioso] §3§l| §bTermina o quiz manualmente.");
        }
        sender.sendMessage(" ");
        sender.sendMessage("§8§l§m-----------------------");
    }
}
