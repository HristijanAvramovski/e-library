import logo from '../../logo.svg';
import './App.css';
import {Component} from "react";
import Countries from "../countries/countries";
import ELibraryService from "../../repository/eLibraryRepository";
import {Route, BrowserRouter as Router, Routes} from "react-router-dom";
import Authors from "../authors/authors";
import Books from "../books/BookList/books";
import data from "bootstrap/js/src/dom/data";
import Header from "../Header/header";
import BookAdd from "../books/BookAdd/bookAdd";
import BookEdit from "../books/BookEdit/bookEdit";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            countries: [],
            authors: [],
            books: [],
            bookCategories: [],
            selectedBook: {}
        }
    }
    render() {
        return (
            <Router>
                <Header/>
                <Routes>
                    <Route path="/" element={<Books books={this.state.books} onDelete={this.deleteBook} onEdit={this.getBook} onMark={this.markAsTaken}/>}/>
                    <Route path="/books/edit/:id" element={<BookEdit authors={this.state.authors} bookCategories={this.state.bookCategories} onEditBook={this.editBook} book={this.state.selectedBook}/>}/>
                    <Route path="/books/add" element={<BookAdd authors={this.state.authors} bookCategories={this.state.bookCategories} onAddBook={this.addBook}/>}/>
                    <Route path="/countries" element={<Countries countries={this.state.countries} />} />
                    <Route path="/authors" element={<Authors authors={this.state.authors} />} />
                </Routes>
            </Router>
        )
    }
    loadBookCategories = () => {
        ELibraryService.fetchBookCategories()
            .then((data) =>{
                this.setState({
                    bookCategories: data.data
                })
            })
    }
    markAsTaken = (id) => {
        ELibraryService.markAsTaken(id)
            .then(() => {
                this.loadBooks();
            })
    }
    getBook = (id) => {
        ELibraryService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            })
    }
    editBook = (id, name, category, authorId, availableCopies) => {
        ELibraryService.editBook(id, name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }
    addBook = (name, category, authorId, availableCopies) => {
        ELibraryService.addBook(name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }
    deleteBook = (id) => {
        ELibraryService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }
    loadBooks = () => {
        ELibraryService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            })
    }
    loadAuthors = () => {
        ELibraryService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            })
    }
    loadCountries = () => {
        ELibraryService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries: data.data
                })
            })
    }
    componentDidMount() {
        this.loadCountries();
        this.loadAuthors();
        this.loadBooks();
        this.loadBookCategories();
    }
}

export default App;
