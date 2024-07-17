import React, { useState } from 'react';
import { Link } from "react-router-dom";

const CheckoutForm = ({ products }) => {
    // 產品根據 id 排序
    products.sort((a, b) => {
        return a.id - b.id;

    });

    const [currentPage, setCurrentPage] = useState(1);
    const [productsPerPage, setProductsPerPage] = useState(4);


    const indexOfLastProduct = currentPage * productsPerPage;
    const indexOfFirstProduct = indexOfLastProduct - productsPerPage;
    const currentProducts = products.slice(indexOfFirstProduct, indexOfLastProduct);

    const pageNumbers = [];
    for (let i = 1; i <= Math.ceil(products.length / productsPerPage); i++) {
        pageNumbers.push(i);
    }

    return (
        <div className='container'>
            <h1>訂購清單商品</h1>
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Price</th>
                        <th>Qty</th>
                        <th>Image</th>
                    </tr>
                </thead>
                <tbody>
                    {currentProducts.map(product => (

                        <tr>
                            <td><Link to={`/product/${product.id}`} key={product.id}>
                                {product.id} </Link></td>
                            <td>{product.title}</td>
                            <td>{product.price}</td>
                            <td>{product.quantity}</td>
                            <td>
                                <img src={`http://localhost:8080/products/productImage?code=${product.id}`} style={{ width: '50%', height: '120px' }} alt={product.title} />
                            </td>

                        </tr>

                    ))}
                </tbody>
            </table>
            <ul className="pagination">
                {pageNumbers.map(number => (
                    <li key={number} className={`page-item ${number === currentPage ? 'active' : ''}`}>
                        <a onClick={() => setCurrentPage(number)} className="page-link">{number}</a>
                    </li>
                ))}
            </ul>
        </div >
    );
};
export default CheckoutForm;

 
