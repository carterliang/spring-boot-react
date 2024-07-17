import React ,{useEffect,useState} from 'react';
import { Container, Row, Col, Card,Form } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const Cart = ({ getCartProduct }) => {
   // var items = localStorage.getItem('localCart');
   const navigate = useNavigate();
    const [products, setProducts] = useState([]);
    useEffect(() => {
        const items = localStorage.getItem('localCart');
        if (items) {
            setProducts(JSON.parse(items));
            console.log("Carts:" + JSON.stringify(JSON.parse(items)));
        }
    }, []);

    const handleQuantityChange = (productId, newQuantity) => {
        const updatedProducts = products.map((product) => {
            if (product.id === productId) {
                //加入 quantity 欄位
                return { ...product, quantity: parseInt(newQuantity) };
            }
            return product;
        });
        setProducts(updatedProducts);
        localStorage.setItem('localCart', JSON.stringify(updatedProducts));
    };
    const checkout = () => {
        console.log('carts checkout:');
        console.log(products);
        getCartProduct(products);
        navigate('/checkout');
    };

    return (
        products.length > 0 ? (
            <Container>
                <Row>
                    <Row>
                        {products.map(product => (
                            <Col key={product.id} md={3}>

                                <Card>
                                    <Card.Img variant="top" style={{ width: '100%', height: '320px' }} src={product.image}></Card.Img>
                                    <Card.Body>
                                        <Card.Title>{product.title}</Card.Title>
                                        <Card.Text>價格： {product.price.toFixed(2)}</Card.Text>
                                        {/* 其他產品詳細資訊 */}
                                        <Form.Group controlId="formQuantity">
                                           <Form.Label>數量</Form.Label>
                                           <Form.Control
                                            type="number"
                                            value={product.quantity}
                                            onChange={(e) => handleQuantityChange(product.id, e.target.value)}
                                           />
                                        </Form.Group>

                                    </Card.Body>
                                </Card>

                            </Col>
                        ))}
                    </Row>
                </Row>
                <button className='btn btn-primary' onClick={checkout}>結帳</button>
            </Container>
        ) : (
            <div style={{ width: "100%", display: "flex", justifyContent: "center" }}>
                <h2>No Data</h2>
            </div>
        )
    );
}

export default Cart;


 
