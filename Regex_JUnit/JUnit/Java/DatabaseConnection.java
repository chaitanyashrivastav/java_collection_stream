package org.example ;

class DatabaseConnection{
    private boolean isConnected ;

    public String connect(){
        isConnected = true;
        return "Connected with the database";
    }

    public String disconnect(){
        isConnected = false ;
        return "Disconnected....";
    }

    public boolean isConnected(){
        return isConnected;
    }
}