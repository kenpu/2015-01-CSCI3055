package main

import "fmt"

func main() {
	// wont compile due to type error
	var a int = 1
	var b string = "hello"

	fmt.Println(a * b)
}
