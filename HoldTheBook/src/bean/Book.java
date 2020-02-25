package bean;

public class Book {
	String Name,Date_of_publish,Image,Quantity;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDate_of_publish() {
		return Date_of_publish;
	}

	public void setDate_of_publish(String date_of_publish) {
		Date_of_publish = date_of_publish;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getQuantity() {
		System.out.println("bean11111"+ Quantity);
		return Quantity;
		
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}
	

}
