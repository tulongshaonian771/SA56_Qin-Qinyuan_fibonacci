import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // 引入Bootstrap样式文件
import { Container, Form, Button, Card } from 'react-bootstrap';
import axios from 'axios';

const App = () => {
    const [n, setN] = useState('');
    const [result1, setResult1] = useState('');
    const [result2, setResult2] = useState('');

    const handleInputChange = (event) => {
        setN(event.target.value);
    };

    const fetchData = () => {
        axios
            .get(`http://localhost:8080/FibonacciSequence?element=${n}`)
            .then((response) => {
                const saying = response.data;
                const number = parseInt(n);
                    setResult1(saying.fibonacci.join(', '));
                    setResult2(saying.sorted.join(', '));
            })
            .catch((error) => {
                console.error(error);
                setResult1('Error occurred while fetching data.');
            });
    };

    return (
        <Container className="mt-5">
            <Card>
                <Card.Body>
                    <Form>
                        <Form.Group>
                            <Form.Label>Enter a number:</Form.Label>
                            <Form.Control
                                type="number"
                                min={1}
                                max={100}
                                value={n}
                                onChange={handleInputChange}
                            />
                        </Form.Group>
                        <Button variant="primary" onClick={fetchData}>
                           Get Fibonacci sequence
                        </Button>
                    </Form>
                    <div className="mt-3">
                        <strong>Result:</strong>
                        <p>{result1}</p>
                        <p>{result2}</p>
                    </div>
                </Card.Body>
            </Card>
        </Container>
    );
}

export default App;
