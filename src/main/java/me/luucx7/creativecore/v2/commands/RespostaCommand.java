package me.luucx7.creativecore.v2.commands;

import me.luucx7.creativecore.v2.api.Quiz;
import me.luucx7.creativecore.v2.api.Resposta;
import me.luucx7.creativecore.v2.managers.QuizManager;
import me.luucx7.creativecore.v2.model.RespostaImpl;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RespostaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§cApenas jogadores podem executar este comando!");
            return true;
        }
        if (!QuizManager.quizHappeningNow()) {
            commandSender.sendMessage("§cNenhum quiz está ocorrendo agora!");
            return true;
        }
        Resposta resposta = new RespostaImpl(commandSender, strings, QuizManager.getQuiz());
        Quiz quiz = QuizManager.getQuiz();
        quiz.addAnswer(resposta);
        return false;
    }
}
