import java.util.Comparator;

public class comp implements Comparator<Integer> {

	@Override
	public int compare(Integer arg1, Integer arg2) {
		if(arg1>arg2)
				return 1;
		
		return -1;
	}

}
