use std::io;

fn main() {
    println!("Guess a number");

    println!("Your choice: ");

    let mut guess = String::new();

    io::stdin()
        .read_line(&mut guess)
        .expect("Failed to readline");

    println!("You guessed {}", guess);
}
