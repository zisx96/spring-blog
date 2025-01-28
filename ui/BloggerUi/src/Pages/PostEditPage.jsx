import React, { useEffect, useState } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { getPostById, editPost } from '../Api/BlogApi'; // Import API methods

const PostEditPage = () => {
    const { id } = useParams();  
    const [post, setPost] = useState(null);  
    const navigate = useNavigate();

    useEffect(() => {
        const fetchPost = async () => {
            const { data } = await getPostById(id);  
            setPost(data);
        };
        fetchPost();
    }, [id]);

    if (!post) return <div className="text-center text-lg">Loading...</div>;

   
    const handleChange = (e) => {
        const { name, value } = e.target;
        setPost((prevPost) => ({
            ...prevPost,
            [name]: value,
        }));
    };

    
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await editPost(id, post); 
            navigate(`/${id}`);  
        } catch (error) {
            console.error('Error updating post:', error);
        }
    };

    return (
        <div className="w-full bg-gray-50 py-6 px-4">
            <div className="max-w-6xl mx-auto bg-white p-6 rounded-lg">
                <h2 className="text-3xl font-bold text-gray-900 mb-4">Edit Post</h2>

                <form onSubmit={handleSubmit}>
                    {/* Title */}
                    <div className="mb-4">
                        <label htmlFor="title" className="block text-lg font-semibold text-gray-700">Title</label>
                        <input
                            type="text"
                            id="title"
                            name="title"
                            value={post?.title || ''}
                            onChange={handleChange}
                            className="w-full p-3 border rounded-lg mt-2"
                        />
                    </div>

                    {/* Author */}
                    <div className="mb-4">
                        <label htmlFor="author" className="block text-lg font-semibold text-gray-700">Author</label>
                        <input
                            type="text"
                            id="author"
                            name="author"
                            value={post?.author || ''}
                            onChange={handleChange}
                            className="w-full p-3 border rounded-lg mt-2"
                        />
                    </div>

                    {/* Subheading */}
                    <div className="mb-4">
                        <label htmlFor="subheading" className="block text-lg font-semibold text-gray-700">Subheading</label>
                        <input
                            type="text"
                            id="subheading"
                            name="subheading"
                            value={post?.subheading || ''}
                            onChange={handleChange}
                            className="w-full p-3 border rounded-lg mt-2"
                        />
                    </div>

                    {/* Content */}
                    <div className="mb-4">
                        <label htmlFor="content" className="block text-lg font-semibold text-gray-700">Content</label>
                        <textarea
                            id="content"
                            name="content"
                            value={post?.content || ''}
                            onChange={handleChange}
                            className="w-full p-3 border rounded-lg mt-2"
                            rows="5"
                        ></textarea>
                    </div>

                    {/* Image URL */}
                    <div className="mb-4">
                        <label htmlFor="image_url" className="block text-lg font-semibold text-gray-700">Image URL</label>
                        <input
                            type="text"
                            id="image_url"
                            name="image_url"
                            value={post?.imageUrl || ''}
                            onChange={handleChange}
                            className="w-full p-3 border rounded-lg mt-2"
                        />
                    </div>

                    {/* Submit Button */}
                    <div className="mt-6">
                        <button
                            type="submit"
                            className="px-6 py-2 bg-blue-600 text-black rounded-md hover:bg-blue-700"
                        >
                            Save Changes
                        </button>
                    </div>
                </form>

                {/* Cancel Button */}
                <div className="mt-4">
                    <button
                        className="px-6 py-2 bg-gray-500 text-BLACK rounded-md hover:bg-gray-600"
                        onClick={() => navigate(`/${id}`)}  // Redirect back to the post detail page
                    >
                        Cancel
                    </button>
                </div>
            </div>
        </div>
    );
};

export default PostEditPage;
