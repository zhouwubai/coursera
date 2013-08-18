function [J, grad] = costFunctionReg(theta, X, y, lambda)
%COSTFUNCTIONREG Compute cost and gradient for logistic regression with regularization
%   J = COSTFUNCTIONREG(theta, X, y, lambda) computes the cost of using
%   theta as the parameter for regularized logistic regression and the
%   gradient of the cost w.r.t. to the parameters. 

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;
grad = zeros(size(theta));

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta.
%               You should set J to the cost.
%               Compute the partial derivatives and set grad to the partial
%               derivatives of the cost w.r.t. each parameter in theta

n = length(grad);
% calculate first part of cost function
h_x = sigmoid(X * theta);
for i=1:m
        J += -y(i) * log(h_x(i)) - (1 - y(i)) * log(1 - h_x(i));
end 
J = J / m;

% calculate second part of cost function

tmpTheta = theta(2:n);
tmpTheta = tmpTheta .* tmpTheta;
J += sum(tmpTheta) * lambda / (2 * m);


% calculate derivative
grad = X' * (h_x - y) / m;
grad(2:n) +=  theta(2:n) * (lambda / m);



% =============================================================

end
