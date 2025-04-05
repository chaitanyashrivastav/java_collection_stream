package org.example ;

class Timed_task{
    public static String longRunningTask(){
        try{
            Thread.sleep(3000) ;
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return "Task was interrupted" ;
        }
        return "Task completed" ;
    }
}