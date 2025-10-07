import { render, screen } from '@testing-library/react';
import App from './App';

test('renders Full Stack App heading', () => {
  render(<App />);
  const headingElement = screen.getByText(/Full Stack App/i);
  expect(headingElement).toBeInTheDocument();
});

test('renders Add User button', () => {
  render(<App />);
  const buttonElement = screen.getByText(/Add User/i);
  expect(buttonElement).toBeInTheDocument();
});

test('renders Users heading', () => {
  render(<App />);
  const usersHeading = screen.getByText(/Users/i);
  expect(usersHeading).toBeInTheDocument();
});