import React from 'react'
import './css/header.css'
import ABCLogo from '../images/ABC.svg';
import HRCLogo from '../images/HRC.svg';

function Header() {

    return <div className='header-hrc'>
        <div className='imagees-hrc'>
            <img src={ABCLogo} width='280' height='39' alt="abc" className='imgabc' />
            <img src={HRCLogo} width='180' height='35' alt="hrc" className='imghrc' />
        </div>
        <div>
            <h3 className='headertitle'>Invoice List</h3>
        </div>
    </div>
}

export default Header



