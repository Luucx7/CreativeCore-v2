package me.luucx7.creativecore.v2.model;

import me.luucx7.creativecore.v2.api.Quiz;
import me.luucx7.creativecore.v2.api.RespostaTentativa;
import org.bukkit.command.CommandSender;

import java.time.LocalDateTime;

public class RespostaImpl implements RespostaTentativa {

    private final CommandSender sender;
    private final String[] args;
    private final Quiz quiz;
    private final LocalDateTime when;

    public RespostaImpl(CommandSender who, String[] arguments, Quiz quiz) {
        this.sender = who;
        this.args = arguments;
        this.quiz = quiz;

        this.when = LocalDateTime.now();
    }

    @Override
    public Quiz getQuiz() {
        return quiz;
    }

    @Override
    public String[] getText() {
        return args;
    }

    public LocalDateTime getTime() {
        return when;
    }
}
