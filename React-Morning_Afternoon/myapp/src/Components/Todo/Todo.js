import React from 'react';
import TodoInput from './TodoInput';
import TodoList from './TodoList';
import './Todo.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import Container from 'react-bootstrap/Container';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Button from 'react-bootstrap/Button';

class Todo extends React.Component {

    state = {
        todo : '',
        todos : [
        {id : 1,  todo: "Dolores in voluptatem tenetur praesentium omnis repellendus voluptatem quaerat.", marked: true},
        {id : 2,  todo: "Assumenda placeat ea voluptatem voluptate qui", marked: false},
        {id : 3,  todo: "laboriosam mollitia et enim quasi adipisci quia provident illum", marked: false},
        {id : 4,  todo: "qui ullam ratione quibusdam voluptatem quia omnis", marked: true},
        {id : 5,  todo: "illo est ratione doloremque quia maiores aut", marked: true},
        {id : 6,  todo: "molestiae perspiciatis ipsa", marked: false},
        {id : 7,  todo: "illo est ratione doloremque quia maiores aut", marked: true},
        {id : 8,  todo: "vero rerum temporibus dolor", marked: false}
    ],
        filterBy: 'all',
        count: 10
    }

    // Delete Handler

    todoDeleteHandler = (id) => {
        const { todos } = this.state;
        // console.log(id);
        const newTodos = todos.filter((data) => {
           return id !== data.id;
        })

        this.setState({ todos: newTodos })
    }

    // Filter Usinf Marked State

    showAllHandler = () => {
        this.setState({filterBy : 'all'});
    }

    showCompletedHandler = () => {
        this.setState({filterBy : 'completed'});
    }

    showAPendingHandler = () => {
        this.setState({filterBy : 'pending'});
    }

    // Copy the task and push it to the last of the Array

    copyHandler = (id) => {
        const {todos, count} = this.state;

        const elementsIndex = todos.findIndex(element => element.id === id )
        const element = todos[elementsIndex];
        //console.log(newCount);
        const newTodos = [...todos]

        newTodos.push({id : count+1, todo : element.todo, marked : false});
        this.setState((prevState) =>({ todos: newTodos, todo: "", count: prevState.count+1}))
    }

    markTaskAsCompleted = (id) => {
        const { todos } = this.state;

        const newTodos = [...todos];

        const elementsIndex = todos.findIndex(element => element.id === id )

        newTodos[elementsIndex] = {
            ...newTodos[elementsIndex],
             marked: !newTodos[elementsIndex].marked
            };

        this.setState({ todos: newTodos });
    }

    handleOnChnge = (event) => {
        // console.log(event.target.value);
        this.setState({todo: event.target.value})
    }
    
    addTask = () => {
        const {todo, todos, count} = this.state;
        //console.log(newCount);
        const newTodos = [...todos]
        if(todo !== "") {
            newTodos.push({id : count+1, todo : todo, marked : false});
            this.setState((prevState) =>({ todos: newTodos, todo: "", count: prevState.count+1}))
        }
    }

    render() {
        // console.log(this.state);
        let filteredTodos = [];

        if(this.state.filterBy === 'all') {
            filteredTodos = this.state.todos;
        } else if(this.state.filterBy === 'completed') {
            filteredTodos = this.state.todos.filter(data => {
                return data.marked === true;
            })
        } else if(this.state.filterBy === 'pending') {
            filteredTodos = this.state.todos.filter(data => {
                return data.marked === false;
            })
        }


        return (
            <div className="container">
                <Container>
                    <h1>TODO APPLICATION</h1>
                    <Row className="justify-content-md-center row1">
                        <Col>
                            <Button variant="primary" onClick = {this.showAllHandler}>Show All Todos</Button>
                        </Col>
                        <Col>
                            <Button variant="primary" onClick = {this.showCompletedHandler}>Show Completed Todos</Button>
                        </Col>
                        <Col>
                            <Button variant="primary" onClick = {this.showAPendingHandler}>Show Pending Todos</Button>
                        </Col>
                    </Row>
                    <TodoInput placeholder="Add new Task" value = {this.state.todo} onChange = {this.handleOnChnge} addTask={this.addTask}/>
                    <TodoList 
                        todos={filteredTodos}  
                        markTaskAsCompleted = {this.markTaskAsCompleted}
                        todoDeleteHandler = {this.todoDeleteHandler}
                        copyHandler = {this.copyHandler}
                        />
                </Container>
            </div>
        )
    }
}
export default Todo;