import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Login from './Login';
import Store from './Store';
import ShowProduct from './ShowProduct';
import Cart from './Cart';
import CheckoutForm from './CheckoutForm';

function LoginProductMain() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [username, setUsername] = useState('');
    const [shopitem, setShopitem] = useState(0);
    const [cartproducts,setCartProducts]=useState([]);

    //changeItem函數修改購買數字
    const changeItem=(shopitem)=>{
         setShopitem(shopitem)
    }

    const onLogin = (username) => {
        if (username != null) {
            setIsLoggedIn(true);
            setUsername(username);
        } else {
            setIsLoggedIn(false);
            alert('登入失敗');
        }

    };
    // Function to handle logout
    const onLogout = () => {
        setIsLoggedIn(false);
        setUsername('');
        localStorage.clear();
        setShopitem(0);
    };
    const getCartProduct = (pts) => {
        setCartProducts(pts);
    };

    return (

        <Router>
            <div className='contrainer'>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <div className="navbar-nav">                        
                        <Link to="/" className="nav-link">帳戶登入</Link>
                        <Link to="/products" className="nav-link">產品</Link>
                    </div>

                    <div className="navbar-nav ms-auto">
                       <Link to="/showcart" className="nav-link">購物車</Link><span className="nav-link">({shopitem})</span>
                        {isLoggedIn ? (
                            <span className="nav-link">歡迎, {username}！<button className="btn btn-link" onClick={onLogout}>登出</button></span>
                        ) : (
                            <span className="nav-link">未登入</span>
                        )}
                    </div>
                </nav>

                <div className="container">
                    <Routes>
                        <Route path="/" element={<Login onLogin={onLogin} />} />
                        <Route path="/products" element={<Store />} /> 
                        <Route path="/product/:pid" element={<ShowProduct changeItem={changeItem} />} />   
                        <Route path="/showcart" element={<Cart getCartProduct={getCartProduct}/>} />
                        <Route path="/checkout" element={<CheckoutForm products={cartproducts} />} />
                    </Routes>
                </div>
            </div>
        </Router>
    );
}

export default LoginProductMain;
