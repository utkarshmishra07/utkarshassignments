package mavinproject.qanda.beans;

import java.util.List;

public class Question {
	
	private int qid;
	private String question;
	private List<Answer> answers;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	@Override
	public String toString() {
		return "Question [qid=" + qid + ", question=" + question + ", answers=" + answers + "]";
	}
}
