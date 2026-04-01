package com.lulan.shincolle.team;

import com.lulan.shincolle.utility.LogHelper;

import java.util.ArrayList;
import java.util.List;

public class TeamData {
    protected int teamID;
    protected String teamName;
    protected String leaderName;
    protected List<Integer> teamBanID;
    protected List<Integer> teamAllyID;

    public TeamData() {
        this.teamID = 0;
        this.teamName = "   ";
        this.leaderName = "   ";
        this.teamBanID = new ArrayList<>();
        this.teamAllyID = new ArrayList<>();
    }

    public String getTeamName() {
        return this.teamName;
    }

    public String getTeamLeaderName() {
        return this.leaderName;
    }

    public int getTeamID() {
        return this.teamID;
    }

    public List<Integer> getTeamBannedList() {
        if (this.teamBanID == null) {
            this.teamBanID = new ArrayList<>();
        }
        return this.teamBanID;
    }

    public List<Integer> getTeamAllyList() {
        if (this.teamAllyID == null) {
            this.teamAllyID = new ArrayList<>();
        }
        return this.teamAllyID;
    }

    public void setTeamName(String par1) {
        this.teamName = par1;
    }

    public void setTeamLeaderName(String par1) {
        this.leaderName = par1;
    }

    public void setTeamID(int par1) {
        this.teamID = par1;
    }

    public void setTeamBannedList(List<Integer> par1) {
        this.teamBanID = par1;
    }

    public void setTeamAllyList(List<Integer> par1) {
        this.teamAllyID = par1;
    }

    public void addTeamAlly(int par1) {
        if (par1 > 0 && this.teamAllyID != null && !this.teamAllyID.contains(par1) && !this.teamBanID.contains(par1)) {
            this.teamAllyID.add(par1);
            LogHelper.debug("DEBUG: team data: add ally: team " + this.teamName + " add " + par1);
        }
    }

    public void removeTeamAlly(int par1) {
        if (par1 > 0 && this.teamAllyID != null && this.teamAllyID.contains(par1)) {
            this.teamAllyID.remove((Object)par1);
            LogHelper.debug("DEBUG : team data: remove ally: team " + this.teamName + " remove " + par1);
        }
    }

    public void addTeamBanned(int par1) {
        if (par1 > 0 && this.teamBanID != null && !this.teamBanID.contains(par1) && !this.teamAllyID.contains(par1)) {
            this.teamBanID.add(par1);
            LogHelper.debug("DEBUG: team data: add banned: team " + this.teamName + " add " + par1);
        }
    }

    public void removeTeamBanned(int par1) {
        if (par1 > 0 && this.teamBanID != null && this.teamBanID.contains(par1)) {
            this.teamBanID.remove((Object)par1);
            LogHelper.debug("DEBUG: team data: remove banned: team " + this.teamName + " remove " + par1);
        }
    }
}
