package com.devbever.beans;

public class Match {
	private int idMatch;
	
	private String winnerFirstname;
	private String winnerLastname;
	
	private String finalistFirstname;
	private String finalistLastname;
	
	private int idTournament;
	private int year;

	public Match() {
	}

	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	public String getWinnerFirstname() {
		return winnerFirstname;
	}

	public void setWinnerFirstname(String winnerFirstname) {
		this.winnerFirstname = winnerFirstname;
	}

	public String getWinnerLastname() {
		return winnerLastname;
	}

	public void setWinnerLastname(String winnerLastname) {
		this.winnerLastname = winnerLastname;
	}

	public String getFinalistFirstname() {
		return finalistFirstname;
	}

	public void setFinalistFirstname(String finalistFirstname) {
		this.finalistFirstname = finalistFirstname;
	}

	public String getFinalistLastname() {
		return finalistLastname;
	}

	public void setFinalistLastname(String finalistLastname) {
		this.finalistLastname = finalistLastname;
	}

	public int getIdTournament() {
		return idTournament;
	}

	public void setIdTournament(int idTournament) {
		this.idTournament = idTournament;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
