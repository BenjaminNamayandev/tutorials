fn main() {
    let numbers: [i32; 5] = [1, 2, 3, 4, 5];
    println!("amount of numbers = {:?}", numbers);

    let fruits: [&str; 3] = ["Orange", "Apple", "Banana"];

    println!("{:?}", fruits);

    println!("{}", fruits[0]);
    println!("{}", fruits[1]);
    println!("{}", fruits[2]);

    //tuples, can have mixed datatypes
    //let human: (&str, i32, bool) = ("Alice", 30, false);
    let mixed_tuple = ("Krat", 30, false, 8.21, fruits);

    println!("{:?}", mixed_tuple);
}
