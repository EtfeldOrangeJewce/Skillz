package bots;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.Constants;

import pirates.game.Direction;
import pirates.game.Island;
import pirates.game.Pirate;
import pirates.game.PirateBot;
import pirates.game.PirateGame;
import sun.security.ssl.Debug;




public class MyBot implements PirateBot {
	private int a=-1, b=-1;
	private Island island1, island2;
			public Island min(List<Island> is, Pirate pr, PirateGame game){
				
				Island smIs = is.get(0);
				int min=game.distance(pr,is.get(0));
				for(int i=0;i<is.size();i++){
					if(game.distance(pr, is.get(i))<min){//&&is.get(i).getOwner()!=pirates.game.Constants.ME 
						min=game.distance(pr, is.get(i));
						smIs=is.get(i);
					}
				
		}
		return smIs;
	}
	
	
	public void doTurn(PirateGame game) {
		try{
		    if (game.notMyIslands().size() == 0) {// checks if we have evreything
		        return;
			}
		   
		   else{
		    
		    
		   
		    ArrayList<Island>islands = (ArrayList<Island>) game.notMyIslands();
		    a=-1;
		    b=-1;
		    for(int i=0; i<3; i++){
		    	if(!game.allMyPirates().get(i).isLost()){
		    		a=i;
		    		break;
		    	}
		    		
		    }
		    for(int i=4; i<6; i++){
		    	if(!game.allMyPirates().get(i).isLost()){
		    		b=i;
		    		break;
		    	}
		    		
		    }
		    if(a!=-1){
		    if(island2!=null)
		    	islands.remove(island2);
		    if(!islands.isEmpty())
		        island1 = min(islands, game.allMyPirates().get(a), game);
		    islands.remove(island1);
		    
		    
		    for (int i=0;i<3;i++){
		    	
		    	if(island1.getTeamCapturing() != pirates.game.Constants.ME && island1.getOwner() != pirates.game.Constants.ME)
		    			if(!game.allMyPirates().get(i).isLost()){
		    				game.setSail(game.allMyPirates().get(i),game.getDirections(game.allMyPirates().get(i), island1).get(0));
		    			}
		    	
		    }
		    
		    if(island2!=null){
		    	if(!game.myIslands().contains(island2)){//island2.getOwner()!=pirates.game.Constants.ME
			    	islands.add(island2);
		    	}
		    }
		    if(b!=-1)
			    if(!islands.isEmpty()){
			         island2 = min(islands, game.allMyPirates().get(b), game);
		    }
		    for(int i=3; i<6; i++){
		    	if(island2!=null)
		    		if(island2.getTeamCapturing()!= pirates.game.Constants.ME && island2.getOwner() != pirates.game.Constants.ME)
	    			if(!game.allMyPirates().get(i).isLost()){
	    				game.setSail(game.allMyPirates().get(i),game.getDirections(game.allMyPirates().get(i), island2).get(0));
	    			}
	    	}
		    }
		    	
		    
		   }
		  
		 
		}
	catch(Exception e){
		
		game.debug("FUUYCK"+e.getStackTrace());
	}
	}

	}






