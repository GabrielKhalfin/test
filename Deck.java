package final330;


import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards;
	
	public Deck(){
		this.cards = new ArrayList<Card>();
	
	}
	
	//Add 52 playing cards to a deck
	public void createFullDeck(){
		for(Suit cardSuit : Suit.values()){
			for(Value cardValue : Value.values()){
				this.cards.add(new Card(cardSuit,cardValue));
			}
		}
	}
	
	
public void shuffle(){
	ArrayList<Card> tempDeck = new ArrayList<Card>();
	Random random = new Random();
	int randomCardIndex = 0;
	int originalSize = this.cards.size();
	for(int i = 0; i < originalSize; i++){
		randomCardIndex = random.nextInt((this.cards.size()));
		//throw random card into new deck
		tempDeck.add(this.cards.get(randomCardIndex));
		//remove picked from old deck
		this.cards.remove(randomCardIndex);
	}
	
	//set this.deck to our newly shuffled deck
	this.cards = tempDeck;
}
	
	
	public void removeCard(int i){
		this.cards.remove(i);
	}

	public Card getCard(int i){
		return this.cards.get(i);
	}
	
	public void addCard(Card addCard){
		this.cards.add(addCard);
	}
	
	public void draw(Deck decksCards){
		this.cards.add(decksCards.getCard(0));
		decksCards.removeCard(0);
	}
	
	
	public int deckSize(){
		return this.cards.size();
	}
	
	//Calculate the value of deck
	public int cardNum(){
		int totalValue = 0;
		int aces = 0;
		//For every card in the deck
		for(Card aCard : this.cards){
			//Switch of possible values
			switch(aCard.getValue()){
			case TWO: totalValue += 2; break;
			case THREE: totalValue += 3; break;
			case FOUR: totalValue += 4; break;
			case FIVE: totalValue += 5; break;
			case SIX: totalValue += 6; break;
			case SEVEN: totalValue += 7; break;
			case EIGHT: totalValue += 8; break;
			case NINE: totalValue += 9; break;
			case TEN: totalValue += 10; break;
			case JACK: totalValue += 10; break;
			case QUEEN: totalValue += 10; break;
			case KING: totalValue += 10; break;
			case ACE: aces += 1; break;
			}			
		}
		
		//Aces value
		for(int i = 0; i < aces; i++){
			if (totalValue > 10){
				totalValue += 1;
			}
			else{
				totalValue += 11;
			}
		}
		
		//Return
		return totalValue;
	
	}
		public String toString(){
			String cardStringt = "";
			int i = 0;
			for(Card aCard : this.cards){
				cardStringt += "\n" + aCard.toString();
				i++;
			}
			return cardStringt;
		}
	
	
}
