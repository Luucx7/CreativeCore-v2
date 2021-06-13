package me.luucx7.creativecore.v2.model;

import me.luucx7.creativecore.v2.api.Quiz;
import me.luucx7.creativecore.v2.api.Resposta;
import me.luucx7.creativecore.v2.api.RespostaCerta;
import me.luucx7.creativecore.v2.managers.QuizManager;

import java.util.LinkedList;
import java.util.List;

public class QuizImpl implements Quiz {

    private final List<Resposta> responses = new LinkedList<>();
    private RespostaCerta correctAnswer;

    private boolean endOnRightAnswer = true;

    private boolean running = false;

    public QuizImpl() {

    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public boolean addAnswer(Resposta resposta) {
        responses.add(resposta);
        boolean isRight = correctAnswer.isRight(resposta);

        if (endOnRightAnswer && isRight) {
            // TODO: Handle right answer
            return true;
        }
        return isRight;
    }

    @Override
    public void setRightAnswer(RespostaCerta rightAnswer) {
        correctAnswer = rightAnswer;
    }

    @Override
    public void start() {
        running = true;
    }

    @Override
    public void stop() {

    }

    private void end() {
        QuizManager.clearQuiz();
    }
}
