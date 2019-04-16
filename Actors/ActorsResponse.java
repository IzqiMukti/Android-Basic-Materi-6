package null;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ActorsResponse{

	@SerializedName("actors")
	private List<ActorsItem> actors;

	public void setActors(List<ActorsItem> actors){
		this.actors = actors;
	}

	public List<ActorsItem> getActors(){
		return actors;
	}
}